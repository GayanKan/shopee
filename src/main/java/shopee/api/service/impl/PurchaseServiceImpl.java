package shopee.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import shopee.api.data.CouponData;
import shopee.api.data.WalletData;
import shopee.api.library.Coupon;
import shopee.api.library.PurchaseCouponSummary;
import shopee.api.library.PurchasedCoupon;
import shopee.api.library.Wallet;
import shopee.api.mapper.DataMapper;
import shopee.api.repository.WalletDataRepository;
import shopee.api.service.IPurchaseService;
import shopee.api.util.APIError;

import java.util.List;
import java.util.Optional;

@Service
@Scope("prototype")
public class PurchaseServiceImpl implements IPurchaseService
{
    @Autowired
    private WalletDataRepository walletDataRepository;
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
            apiError = new APIError( APIError.ERROR, null, "No Wallet Found for the given wallet id" );
        }

        return apiError;
    }

    public APIError<Wallet> purchaseCoupon( PurchasedCoupon coupon, Long walletId )
    {
        return null;
    }

    @Override
    public APIError<Wallet> updateCoupon( PurchasedCoupon coupon, Long walletId, Long couponId )
    {
        return null;
    }

    @Override
    public APIError<Wallet> deleteCoupon( Long walletId, Long couponId )
    {
        return null;
    }

    @Override
    public APIError<List<PurchaseCouponSummary>> getDetailPartnerPurchases( Long partnerId )
    {
        return null;
    }
}
