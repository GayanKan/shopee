package shopee.api.service;

import shopee.api.library.PurchaseCouponSummary;
import shopee.api.library.PurchasedCoupon;
import shopee.api.library.Wallet;
import shopee.api.util.APIError;

import java.util.List;

public interface IPurchaseService
{
    APIError<Wallet> getDetailWallet( Long walletId );

    public APIError<Wallet> purchaseCoupon( PurchasedCoupon coupon, Long walletId );

    APIError<Wallet> updateCoupon( PurchasedCoupon coupon, Long walletId, Long couponId );

    APIError<Wallet> deleteCoupon( Long walletId, Long couponId );

    APIError<List<PurchaseCouponSummary>> getDetailPartnerPurchases( Long partnerId );
}
