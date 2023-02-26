package shopee.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import shopee.api.data.*;
import shopee.api.library.*;

import java.util.List;

@Mapper
public abstract class DataMapper
{
    public static DataMapper dataMapper = Mappers.getMapper( DataMapper.class );

    public abstract Profile mapProfile( ProfileData profileData );

    public abstract List<Profile> mapProfiles( List<ProfileData> profileDataList);

    public abstract Coupon mapCoupon( CouponData couponData );

    public abstract List<Coupon> mapCoupons( List<CouponData> couponDataList );

    public abstract Partner mapPartner( PartnerData partnerData );
    public abstract List<Partner> mapPartners( List<PartnerData> partnerDataList );

    @Mapping( source = "purchasedCouponData", target = "purchasedCoupons" )
    public abstract Wallet mapWallet( WalletData walletData );

    @Mapping(expression = "java(purchasedCoupon.getCouponDetailLink())", target = "qrCode")
    public abstract PurchasedCoupon mapPurchasedCoupon( PurchasedCouponData purchasedCoupon );

    public abstract List<PurchasedCoupon> mapPurchasedCoupons( List<PurchasedCouponData> purchasedCoupons );

    public abstract Payment mapPayment( PaymentData paymentData );
    @Mapping( source = "coupon.rate", target = "amount" )
    public abstract PurchaseCouponSummary mapPurchasedSummaryCoupon( PurchasedCouponData couponData );

    public abstract List<PurchaseCouponSummary> mapPurchasedSummaryCoupons( List<PurchasedCouponData> couponData );
}
