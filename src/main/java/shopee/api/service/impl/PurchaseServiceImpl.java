package shopee.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import shopee.api.data.CouponData;
import shopee.api.data.PaymentData;
import shopee.api.library.*;
import shopee.api.repository.PaymentDataRepository;
import shopee.api.data.PurchasedCouponData;
import shopee.api.data.WalletData;
import shopee.api.mapper.DataMapper;
import shopee.api.repository.PurchasedCouponDataRepository;
import shopee.api.repository.WalletDataRepository;
import shopee.api.service.IPurchaseService;
import shopee.api.util.APIError;
import shopee.api.util.Validator;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@Scope( "prototype" )
public class PurchaseServiceImpl implements IPurchaseService
{
    @Autowired
    private WalletDataRepository walletDataRepository;
    @Autowired
    private PurchasedCouponDataRepository purchasedCouponDataRepository;
    @Autowired
    private PaymentDataRepository paymentDataRepository;

    @Autowired
    private SetupServiceImpl setupService;

    @Override
    public APIError<Wallet> getDetailWallet( Long walletId )
    {
        APIError apiError = new APIError( APIError.SUCCESS, new Object(), "Success" );

        Optional<WalletData> walletData = walletDataRepository.findById( walletId );

        if( walletData.isPresent() )
        {
            Wallet wallet = DataMapper.dataMapper.mapWallet( walletData.get() );
            apiError.setData( wallet );
        }
        else
        {
            apiError = new APIError( APIError.ERROR, null, "No Wallet found for the given wallet id" );
        }

        return apiError;
    }

    public APIError<Wallet> purchaseCoupon( CouponPurchase coupon, Long walletId )
    {
        APIError<Wallet> apiError = new APIError( APIError.SUCCESS, "Purchase coupon success" );

        APIError<Wallet> validate = Validator.validatePurchaseCoupons( coupon );

        if( validate._isSuccess() )
        {
            PurchasedCouponData purchasedCouponData = new PurchasedCouponData();

            APIError<CouponData> couponDataError = setupService.getCouponData( coupon.getCoupon().getId() );
            if( couponDataError._isError() )
            {
                apiError.setMsg( couponDataError.getMsg() );
                return apiError;
            }

            Optional<WalletData> walletData = walletDataRepository.findById( walletId );
            if( !walletData.isPresent() )
            {
                apiError.setMsg( "Incorrect User Wallet" );
                return apiError;
            }

            CouponData couponData = ( CouponData ) couponDataError.getData();
            purchasedCouponData.setCoupon( couponData );
            purchasedCouponData.setCouponId( couponData.getId() );
            purchasedCouponData.setRate( couponData.getRate() );

            purchasedCouponData.setWalletId( walletId );
            purchasedCouponData.setWalletData( walletData.get() );

            purchasedCouponData.setPurchasedDate( new Date( System.currentTimeMillis() ) );

            Date date = new Date( System.currentTimeMillis() );
            LocalDate localDate = date.toLocalDate();
            LocalDate newDate = localDate.plusMonths( 3L ); // TODO to configure

            purchasedCouponData.setExpiryDate( java.sql.Date.valueOf( newDate ) );

            purchasedCouponData.setDiscountPercentage( this.getDiscountPercentage( couponData.getRate() ) ); // TODO Need to take it from the discount pool
            purchasedCouponData.setValid( true );
            purchasedCouponData.setCurrency( "EUR" ); // TODO take this from the coupon

            PurchasedCouponData purchasedCouponDataNew = purchasedCouponDataRepository.saveAndFlush( purchasedCouponData );

            // Save CC payment
            PaymentData paymentData = new PaymentData();
            paymentData.setPaymentId( ( long ) -1 );
            paymentData.setPaymentReference( "test-payment-gateway" );
            paymentData.setTransactionReference( "test-payment-reference" );
            paymentData.setCurrency( coupon.getCoupon().getCurrency() );
            paymentData.setPurchasedCouponId( purchasedCouponDataNew.getId() );
            paymentData.setPurchasedCoupon( purchasedCouponDataNew );
            paymentData.setPaymentAmount( couponData.getRate() );
            paymentData.setPaymentGateway( coupon.getPaymentInfo().getGatewayInfo().getType() );
            paymentData.setCardNumber( coupon.getPaymentInfo().getGatewayInfo().getCardNumber() ); // TODO need to encrypt this

            paymentDataRepository.saveAndFlush( paymentData );

            return getDetailWallet( walletId );
        }
        else
        {
            return validate;
        }
    }

    private float getDiscountPercentage( float rate )
    {
        List<Integer> givenList = Arrays.asList( 5, 10, 15, 20, 25, 30, 40, 45, 50, 60, 70, 75, 90, 100 );
        Random rand = new Random();
        return givenList.get( rand.nextInt( givenList.size() ) );
    }

    @Override
    public APIError<PurchasedCoupon> updateCoupon( PurchasedCoupon coupon, Long walletId, Long couponId, Long partnerProfileId )
    {
        APIError<PurchasedCoupon> apiError = new APIError( APIError.SUCCESS, "Successfully redeemed the coupon" );

        // Validate CouponData
        APIError<CouponData> couponDataError = setupService.getCouponData( coupon.getCoupon().getId() );
        if( couponDataError._isError() )
        {
            apiError.setMsg( couponDataError.getMsg() );
            apiError.setNo( APIError.ERROR );
            return apiError;
        }

        //Validate Wallet
        Optional<WalletData> walletData = walletDataRepository.findById( walletId );
        if( walletData.isEmpty() )
        {
            apiError.setMsg( "Incorrect User Wallet" );
            apiError.setNo( APIError.ERROR );
            return apiError;
        }

        // Validate Purchase Coupon
        Optional<PurchasedCouponData> purchasedCouponData = purchasedCouponDataRepository.findById( couponId );

        if( purchasedCouponData.isEmpty() )
        {
            apiError.setMsg( "Incorrect Purchase Coupon" );
            apiError.setNo( APIError.ERROR );
            return apiError;
        }
        else
        {
            PurchasedCouponData purchasedCouponDataUpdate = purchasedCouponData.get();
            if( purchasedCouponDataUpdate.isPaid() )
            {
                apiError.setMsg( "Coupon is already redeemed. Please select another coupon" );
                apiError.setNo( APIError.ERROR );
                return apiError;
            }
            else if( !purchasedCouponDataUpdate.isValid() )
            {
                apiError.setMsg( "Coupon is not valid" );
                apiError.setNo( APIError.ERROR );
                return apiError;
            }

            purchasedCouponDataUpdate.setValid( false );
            purchasedCouponDataUpdate.setPaid( true );
            purchasedCouponDataUpdate.setPaidDate( new Date( System.currentTimeMillis() ) );
            purchasedCouponDataUpdate.setPartnerProfileId( partnerProfileId );

            PurchasedCouponData purchasedCouponDataNew = purchasedCouponDataRepository.saveAndFlush( purchasedCouponDataUpdate );
            PurchasedCoupon purchasedCouponNew = DataMapper.dataMapper.mapPurchasedCoupon( purchasedCouponDataNew );

            WalletData walletDataUpdate = walletData.get();

            double discountBalance = purchasedCouponDataUpdate.getRate() * ( purchasedCouponDataUpdate.getDiscountPercentage() / 100 );
            walletDataUpdate.setBalance( walletDataUpdate.getBalance() + discountBalance );
            walletDataRepository.saveAndFlush( walletDataUpdate );

            return new APIError( APIError.SUCCESS, purchasedCouponNew, "Successfully redeemed the coupon" );

        }
    }

    @Override
    public APIError<Wallet> deleteCoupon( Long walletId, Long couponId )
    {
        return new APIError( APIError.ERROR, null, "Coupon Delete Not Supported" );

    }

    @Override
    public APIError<List<PurchaseCouponSummary>> getDetailPartnerPurchases( Long partnerId )
    {
        APIError apiError = new APIError( APIError.SUCCESS, new Object(), "Success" );

        List<PurchasedCouponData> couponData = purchasedCouponDataRepository.getPartnerPurchaseCoupons( partnerId );

        if( couponData != null && !couponData.isEmpty() )
        {
            List<PurchaseCouponSummary> purchasedCoupons = DataMapper.dataMapper.mapPurchasedSummaryCoupons( couponData );
            apiError.setData( purchasedCoupons );
        }
        else
        {
            apiError = new APIError( APIError.ERROR, null, "No purchased coupons found for the given partner" );
        }

        return apiError;
    }

    @Override
    public APIError<Payment> getDetailCouponPayments( Long walletId, Long purchasedCouponId )
    {
        APIError apiError = new APIError( APIError.SUCCESS, new Object(), "Success" );

        Optional<PaymentData> paymentData = paymentDataRepository.getDetailCouponPayments( purchasedCouponId );

        if( paymentData.isPresent() )
        {
            Payment payment = DataMapper.dataMapper.mapPayment( paymentData.get() );
            apiError.setData( payment );
        }
        else
        {
            apiError = new APIError( APIError.ERROR, null, "No payment found for the given coupon id" );
        }

        return apiError;
    }

    public APIError<PurchasedCoupon> getPurchaseCouponDetail( Long walletId, Long couponId )
    {
        APIError apiError = new APIError( APIError.SUCCESS, new Object(), "Success" );

        Optional<PurchasedCouponData> couponData = purchasedCouponDataRepository.findById( couponId );

        if( couponData.isPresent() )
        {
            PurchasedCoupon purchasedCoupon = DataMapper.dataMapper.mapPurchasedCoupon( couponData.get() );
            if( purchasedCoupon.isPaid() )
            {
                apiError.setMsg( "This coupon is already redeemed. Please select another coupon" );
                apiError.setNo( APIError.ERROR );
                apiError.setData( purchasedCoupon );
            }
            else if( !purchasedCoupon.isValid() )
            {
                apiError.setMsg( "This coupon is not valid to redeem. Please select another coupon" );
                apiError.setNo( APIError.ERROR );
                apiError.setData( purchasedCoupon );
            }
            else
            {
                apiError.setData( purchasedCoupon );
            }

        }
        else
        {
            apiError = new APIError( APIError.ERROR, null, "No purchased coupon found for the given coupon id" );
        }

        return apiError;
    }
}
