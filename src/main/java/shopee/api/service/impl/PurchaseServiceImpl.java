package shopee.api.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import shopee.api.library.PurchaseCouponSummary;
import shopee.api.library.PurchasedCoupon;
import shopee.api.library.Wallet;
import shopee.api.service.IPurchaseService;
import shopee.api.util.APIError;

import java.util.List;

@Service
@Scope("prototype")
public class PurchaseServiceImpl implements IPurchaseService
{
    @Override
    public APIError<Wallet> getDetailWallet( Long walletId )
    {
        return null;
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
