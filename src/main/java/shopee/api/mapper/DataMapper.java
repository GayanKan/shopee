package shopee.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import shopee.api.data.CouponData;
import shopee.api.data.PartnerData;
import shopee.api.data.ProfileData;
import shopee.api.library.Coupon;
import shopee.api.library.Partner;
import shopee.api.library.Profile;

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
}
