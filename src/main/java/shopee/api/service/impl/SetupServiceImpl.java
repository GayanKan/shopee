package shopee.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import shopee.api.data.CouponData;
import shopee.api.data.CouponDataRepository;
import shopee.api.data.PartnerData;
import shopee.api.library.Coupon;
import shopee.api.library.Partner;
import shopee.api.library.Profile;
import shopee.api.mapper.DataMapper;
import shopee.api.repository.CouponRepository;
import shopee.api.repository.PartnerRepository;
import shopee.api.service.ISetupService;
import shopee.api.util.APIError;
import shopee.api.util.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Scope( "prototype" )
public class SetupServiceImpl implements ISetupService
{
    @Autowired
    private CouponRepository couponRepository;

    @Autowired
    private PartnerRepository partnerRepository;
    @Autowired
    private CouponDataRepository couponDataRepository;
    @Autowired
    private AdminServiceImpl adminService;

    @Override
    public APIError<List<Coupon>> getAllCoupons()
    {
        APIError apiError = new APIError( APIError.SUCCESS, new Object(), "Success" );

        Pageable paging = PageRequest.of( 0, 20, Sort.by( Sort.Direction.ASC, "id" ) );

        Page<CouponData> pagedResult = couponRepository.findAll( paging );

        if( pagedResult.hasContent() )
        {
            List<Coupon> couponList = DataMapper.dataMapper.mapCoupons( pagedResult.getContent() );
            apiError.setData( couponList );
        }
        else
        {
            apiError = new APIError( APIError.ERROR, null, "No Coupons Found" );
        }

        return apiError;
    }

    @Override
    public APIError<Coupon> getCoupon( Long couponId )
    {
        APIError apiError = new APIError( APIError.SUCCESS, new Object(), "Success" );

        Optional<CouponData> couponData = couponDataRepository.findById( couponId );

        if( couponData.isPresent() )
        {
            Coupon couponList = DataMapper.dataMapper.mapCoupon( couponData.get() );
            apiError.setData( couponList );
        }
        else
        {
            apiError = new APIError( APIError.ERROR, null, "No Coupons Found" );
        }

        return apiError;
    }

    @Override
    public APIError<CouponData> getCouponData( Long couponId )
    {
        APIError apiError = new APIError( APIError.SUCCESS, new Object(), "Success" );

        Optional<CouponData> couponData = couponDataRepository.findById( couponId );

        if( couponData.isPresent() )
        {
            apiError.setData( couponData.get() );
            return apiError;
        }
        else
        {
            apiError = new APIError( APIError.ERROR, null, "No Coupon Found for the specified couponId" );
        }

        return apiError;
    }

    @Override
    public APIError<Coupon> addNewCoupon( Coupon coupon )
    {
        CouponData couponData = DataMapper.dataMapper.mapCouponDTOToDAO( coupon );
        couponData.setCurrency( "EUR" );
        CouponData couponDataNew = couponDataRepository.save( couponData );
        return new APIError( APIError.SUCCESS, DataMapper.dataMapper.mapCoupon( couponDataNew ), "Success" );
    }

    @Override
    public APIError<Coupon> updateCoupon( Coupon coupon, Long couponId )
    {
        return null;
    }

    @Override
    public APIError deleteCoupon( Long couponId )
    {
        return null;
    }

    @Override
    public APIError<List<Partner>> getAllPartners( String name )
    {
        Pageable paging = PageRequest.of( 0, 20, Sort.by( Sort.Direction.ASC, "id" ) );
        APIError apiError = new APIError( APIError.SUCCESS, new Object(), "Success" );

        Page<PartnerData> pagedResult = partnerRepository.findAll( paging );

        if( pagedResult.hasContent() )
        {
            List<Partner> couponList = DataMapper.dataMapper.mapPartners( pagedResult.getContent() );
            apiError.setData( couponList );
        }
        else
        {
            apiError = new APIError( APIError.ERROR, null, "No Partners Found" );
        }

        return apiError;
    }

    @Override
    public APIError<List<Partner>> getPartnerDetail( Long partnerId )
    {
        return null;
    }

    @Override
    public APIError<Partner> addNewPartner( Partner partner )
    {
        if( partner.getPartnerProfile() == null )
        {
            return new APIError( APIError.ERROR, null, "Partner Profile is Not Found" );
        }
        else if( Validator.isNullOrEmpty( partner.getLegalName() ) )
        {
            return new APIError( APIError.ERROR, null, "Partner Legal Name Cannot be Empty" );
        }
        else if( Validator.isNullOrEmpty( partner.getMarketingName() ) )
        {
            return new APIError( APIError.ERROR, null, "Partner Marketing Name Cannot be Empty" );
        }
        APIError<Profile> profileNew = adminService.addNewProfile( partner.getPartnerProfile() );

        if( profileNew._isSuccess() )
        {
            PartnerData partnerData = DataMapper.dataMapper.mapPartnerDTOToDAO( partner );
            partnerData.setProfileId( ( ( Profile ) profileNew.getData() ).getProfileId() );
            partnerData.getPartnerProfile().setProfileId( ( ( Profile ) profileNew.getData() ).getProfileId() );
            PartnerData partnerDataNew = partnerRepository.saveAndFlush( partnerData );

            Partner partnerNew = DataMapper.dataMapper.mapPartner( partnerDataNew );

            return new APIError( APIError.SUCCESS, partnerNew, "Partner Creation Success" );
        }
        else
        {
            return new APIError( APIError.ERROR, null, " Error Creating Partner " + partner.getLegalName() + " Error = " +  profileNew.getMsg() );

        }
    }

    @Override
    public APIError<List<Partner>> addNewPartners( List<Partner> partnerList )
    {
        if( partnerList == null || partnerList.isEmpty() )
        {
            return new APIError( APIError.ERROR, null, "PartnerList is Not Found" );
        }

        StringBuilder stringBuilder = new StringBuilder();
        List<Partner> newPartners = new ArrayList<>();

        for( Partner partner : partnerList )
        {
            APIError<Partner> newPartner = addNewPartner( partner );
            if( newPartner._isSuccess() )
            {
                newPartners.add( ( Partner ) newPartner.getData() );
            }
            else
            {
                stringBuilder.append( newPartner.getMsg() );
                stringBuilder.append( " " );
            }
        }


        return new APIError( APIError.SUCCESS, newPartners, " Partner List Created Status = " + stringBuilder );
    }


    @Override
    public APIError<List<Partner>> updatePartner( Coupon coupon, Long couponId )
    {
        return null;
    }

    @Override
    public APIError deletePartner( Long couponId )
    {
        return null;
    }


}
