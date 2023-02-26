package shopee.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shopee.api.library.*;
import shopee.api.service.impl.PurchaseServiceImpl;
import shopee.api.util.APIError;
import shopee.api.util.RequestWrapper;

import java.util.List;

import static shopee.api.util.HeaderUtil.getResponseHeaders;

@RestController
@RequestMapping("purchase-service")
public class PurchaseServiceController
{
    @Autowired
    PurchaseServiceImpl purchaseService;
    @RequestMapping( value = "/wallet/{walletId}", method = RequestMethod.GET, headers = "Accept=application/json" )
    public ResponseEntity<APIError<Wallet>> getDetailWallet( @PathVariable( name = "walletId" ) Long walletId )
    {
        APIError<Wallet> wallet = purchaseService.getDetailWallet( walletId );
        if( wallet._isSuccess() )
        {
            return ResponseEntity.
                           status( HttpStatus.OK ).
                           headers( getResponseHeaders() ).
                           body( wallet );
        }
        else
        {
            return ResponseEntity.
                           status( HttpStatus.NOT_FOUND ).
                           headers( getResponseHeaders() ).
                           body( wallet );
        }
    }

    @RequestMapping( value = "/wallet/{walletId}/coupons/{couponId}", method = RequestMethod.GET, headers = "Accept=application/json" )
    public ResponseEntity<APIError<PurchasedCoupon>> getCouponDetail(  @PathVariable( name = "walletId" ) Long walletId, @PathVariable( name = "couponId" ) Long couponId )
    {
        APIError<PurchasedCoupon> purchaseCouponDetail = purchaseService.getPurchaseCouponDetail( walletId, couponId );
        if( purchaseCouponDetail._isSuccess() )
        {
            return ResponseEntity.
                           status( HttpStatus.OK ).
                           headers( getResponseHeaders() ).
                           body( purchaseCouponDetail );
        }
        else
        {
            return ResponseEntity.
                           status( HttpStatus.NOT_FOUND ).
                           headers( getResponseHeaders() ).
                           body( purchaseCouponDetail );
        }
    }

    @RequestMapping( value = "/wallet/{walletId}/coupons", method = RequestMethod.POST, headers = "Accept=application/json" )
    public ResponseEntity<APIError<Wallet>> addNewCoupon( @RequestBody RequestWrapper<CouponPurchase> couponPurchase, @PathVariable( name = "walletId" ) Long walletId )
    {
        APIError<Wallet> wallet = purchaseService.purchaseCoupon(  couponPurchase.getPayload(), walletId );
        if( wallet._isSuccess() )
        {
            return ResponseEntity.
                           status( HttpStatus.OK ).
                           headers( getResponseHeaders() ).
                           body( wallet );
        }
        else
        {
            return ResponseEntity.
                           status( HttpStatus.NOT_FOUND ).
                           headers( getResponseHeaders() ).
                           body( wallet );
        }
    }

    @RequestMapping( value = "/wallet/{walletId}/coupons/{couponId}", method = RequestMethod.PUT, headers = "Accept=application/json" )
    public ResponseEntity<APIError<Wallet>> updateCoupon( @RequestBody RequestWrapper<PurchasedCoupon> coupon, @PathVariable( name = "walletId" ) Long walletId, @PathVariable( name = "couponId" ) Long couponId )
    {
        APIError<Wallet> wallet = purchaseService.updateCoupon( ( PurchasedCoupon ) coupon.getPayload(), walletId, couponId );
        if( wallet._isSuccess() )
        {
            return ResponseEntity.
                           status( HttpStatus.OK ).
                           headers( getResponseHeaders() ).
                           body( wallet );
        }
        else
        {
            return ResponseEntity.
                           status( HttpStatus.NOT_FOUND ).
                           headers( getResponseHeaders() ).
                           body( wallet );
        }
    }

    @RequestMapping( value = "/wallet/{walletId}/coupons/{couponId}", method = RequestMethod.DELETE, headers = "Accept=application/json" )
    public ResponseEntity<APIError<Wallet>> deleteCoupon( @PathVariable( name = "walletId" ) Long walletId, @PathVariable( name = "couponId" ) Long couponId )
    {
        APIError<Wallet> wallet = purchaseService.deleteCoupon( walletId, couponId );
        if( wallet._isSuccess() )
        {
            return ResponseEntity.
                           status( HttpStatus.OK ).
                           headers( getResponseHeaders() ).
                           body( wallet );
        }
        else
        {
            return ResponseEntity.
                           status( HttpStatus.NOT_FOUND ).
                           headers( getResponseHeaders() ).
                           body( wallet );
        }
    }

    @RequestMapping( value = "/partners/{partnerId}/purchases", method = RequestMethod.GET, headers = "Accept=application/json" )
    public ResponseEntity<APIError<List<PurchaseCouponSummary>>> getDetailPartnerPurchases( @PathVariable( name = "partnerId" ) Long partnerId )
    {
        APIError<List<PurchaseCouponSummary>> purchaseSummary = purchaseService.getDetailPartnerPurchases( partnerId );
        if( purchaseSummary._isSuccess() )
        {
            return ResponseEntity.
                           status( HttpStatus.OK ).
                           headers( getResponseHeaders() ).
                           body( purchaseSummary );
        }
        else
        {
            return ResponseEntity.
                           status( HttpStatus.NOT_FOUND ).
                           headers( getResponseHeaders() ).
                           body( purchaseSummary );
        }
    }

    @RequestMapping( value = "wallet/{walletId}/coupons/{couponId}/payments", method = RequestMethod.GET, headers = "Accept=application/json" )
    public ResponseEntity<APIError<Payment>> getCouponPayment( @PathVariable( name = "walletId" ) Long walletId, @PathVariable( name = "couponId" ) Long couponId  )
    {
        APIError<Payment> purchaseCouponDetail = purchaseService.getDetailCouponPayments( walletId, couponId );
        if( purchaseCouponDetail._isSuccess() )
        {
            return ResponseEntity.
                           status( HttpStatus.OK ).
                           headers( getResponseHeaders() ).
                           body( purchaseCouponDetail );
        }
        else
        {
            return ResponseEntity.
                           status( HttpStatus.NOT_FOUND ).
                           headers( getResponseHeaders() ).
                           body( purchaseCouponDetail );
        }
    }

}
