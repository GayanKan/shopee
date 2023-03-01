package shopee.api.service;

import shopee.api.data.CouponData;
import shopee.api.library.Coupon;
import shopee.api.library.Partner;
import shopee.api.util.APIError;

import java.util.List;

public interface ISetupService
{
    APIError<List<Coupon>> getAllCoupons();

    APIError<Coupon> getCoupon( Long couponId  );

    APIError<CouponData> getCouponData( Long couponId  );

    APIError<Coupon> addNewCoupon( Coupon coupon );

    APIError<Coupon> updateCoupon( Coupon coupon, Long couponId );

    APIError deleteCoupon( Long couponId );

    APIError<List<Partner>> getAllPartners( String name );

    APIError<List<Partner>> getPartnerDetail( Long partnerId );

    APIError<Partner> addNewPartner( Partner partner );

    APIError<List<Partner>> updatePartner( Coupon coupon, Long couponId );

    APIError deletePartner( Long couponId );


}
