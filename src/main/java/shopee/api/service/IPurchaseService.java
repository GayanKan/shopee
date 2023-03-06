package shopee.api.service;

import shopee.api.library.*;
import shopee.api.util.APIError;

import java.util.List;

public interface IPurchaseService
{
    APIError<Wallet> getDetailWallet( Long walletId );

    public APIError<Wallet> purchaseCoupon( CouponPurchase coupon, Long walletId );

    APIError<PurchasedCoupon> updateCoupon( PurchasedCoupon coupon, Long walletId, Long couponId, Long partnerProfileId );

    APIError<Wallet> deleteCoupon( Long walletId, Long couponId );

    APIError<List<PurchaseCouponSummary>> getDetailPartnerPurchases( Long partnerId );

    public APIError<Payment> getDetailCouponPayments( Long walletId, Long purchasedCouponId );

    public APIError<PurchasedCoupon> getPurchaseCouponDetail( Long walletId, Long couponId );
}
