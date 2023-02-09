package shopee.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shopee.api.library.Coupon;
import shopee.api.library.Partner;
import shopee.api.service.impl.SetupServiceImpl;
import shopee.api.util.APIError;

import java.util.List;

import static shopee.api.util.HeaderUtil.getResponseHeaders;

@RestController
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
}
