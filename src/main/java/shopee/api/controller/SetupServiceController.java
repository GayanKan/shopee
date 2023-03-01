package shopee.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shopee.api.library.Coupon;
import shopee.api.library.Partner;
import shopee.api.library.Profile;
import shopee.api.service.impl.SetupServiceImpl;
import shopee.api.util.APIError;
import shopee.api.util.RequestWrapper;

import java.util.List;

import static shopee.api.util.HeaderUtil.getResponseHeaders;

@RestController
@RequestMapping("setup-service")
public class SetupServiceController
{
    @Autowired
    private SetupServiceImpl setupService;

    @RequestMapping( value = "/coupons", method = RequestMethod.GET, headers = "Accept=application/json" )
    public ResponseEntity<APIError<List<Coupon>>> getAllCoupons(  )
    {
        APIError<List<Coupon>> coupons = setupService.getAllCoupons( );
        if( coupons._isSuccess() )
        {
            return ResponseEntity.
                           status( HttpStatus.OK ).
                           headers( getResponseHeaders() ).
                           body( coupons );
        }
        else
        {
            return ResponseEntity.
                           status( HttpStatus.NOT_FOUND ).
                           headers( getResponseHeaders() ).
                           body( coupons );
        }

    }

    @RequestMapping( value = "/partners", method = RequestMethod.GET, headers = "Accept=application/json" )
    public ResponseEntity<APIError<List<Partner>>> getAllPartners( @RequestParam(name = "name", required = false) String name )
    {
        APIError<List<Partner>> partners = setupService.getAllPartners( name );
        if( partners._isSuccess() )
        {
            return ResponseEntity.
                           status( HttpStatus.OK ).
                           headers( getResponseHeaders() ).
                           body( partners );
        }
        else
        {
            return ResponseEntity.
                           status( HttpStatus.NOT_FOUND ).
                           headers( getResponseHeaders() ).
                           body( partners );
        }
    }

    @RequestMapping( value = "/setup/partners", method = RequestMethod.POST, headers = "Accept=application/json" )
    public ResponseEntity<APIError<Partner>> addNewPartner( @RequestBody RequestWrapper<Partner> profile )
    {
        APIError<Partner> newProfile = setupService.addNewPartner( profile.getPayload() );

        if( newProfile._isSuccess() )
        {
            return ResponseEntity.
                           status( HttpStatus.CREATED ).
                           headers( getResponseHeaders() ).
                           body( newProfile );
        }
        else
        {
            return ResponseEntity.
                           status( HttpStatus.INTERNAL_SERVER_ERROR ).
                           headers( getResponseHeaders() ).
                           body( newProfile );
        }

    }

    @RequestMapping( value = "/setup/coupons", method = RequestMethod.POST, headers = "Accept=application/json" )
    public ResponseEntity<APIError<Coupon>> addCoupon( @RequestBody RequestWrapper<Coupon> coupon )
    {
        APIError<Coupon> newCoupon = setupService.addNewCoupon( coupon.getPayload() );

        if( newCoupon._isSuccess() )
        {
            return ResponseEntity.
                           status( HttpStatus.CREATED ).
                           headers( getResponseHeaders() ).
                           body( newCoupon );
        }
        else
        {
            return ResponseEntity.
                           status( HttpStatus.INTERNAL_SERVER_ERROR ).
                           headers( getResponseHeaders() ).
                           body( newCoupon );
        }

    }
}
