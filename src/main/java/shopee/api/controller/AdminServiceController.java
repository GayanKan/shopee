package shopee.api.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shopee.api.library.LoginDetail;
import shopee.api.library.LoginSummary;
import shopee.api.library.Profile;
import shopee.api.service.impl.AdminServiceImpl;
import shopee.api.util.APIError;
import shopee.api.util.RequestWrapper;

import java.rmi.RemoteException;

import static shopee.api.util.HeaderUtil.getResponseHeaders;

@RestController
@RequestMapping( "admin-service" )
public class AdminServiceController
{
    @Autowired
    private AdminServiceImpl adminService;

    @RequestMapping( value = "/setup/user-profiles/{profileId}", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json" )
    public ResponseEntity<APIError<Profile>> getProfileById( @PathVariable( name = "profileId" ) Long profileId ) throws RemoteException
    {
        APIError<Profile> profileData = adminService.getDetailUserProfile( profileId );
        if( profileData._isSuccess() )
        {
            return ResponseEntity.
                           status( HttpStatus.OK ).
                           headers( getResponseHeaders() ).
                           body( profileData );
        }
        else
        {
            return ResponseEntity.
                           status( HttpStatus.NOT_FOUND ).
                           headers( getResponseHeaders() ).
                           body( profileData );
        }
    }

    @RequestMapping( value = "/setup/user-profiles", method = RequestMethod.POST, headers = "Accept=application/json" )
    public ResponseEntity<APIError<Profile>> addNewProfile( @RequestBody RequestWrapper<Profile> profile )
    {
        APIError<Profile> newProfile = adminService.addNewProfile( profile.getPayload() );

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

    @RequestMapping( value = "/auth/user-logins", method = RequestMethod.POST, headers = "Accept=application/json" )
    public ResponseEntity<APIError<LoginSummary>> userLogin( @RequestBody RequestWrapper<LoginDetail> loginDetail, @RequestParam( required = true ) String actions )
    {
        // from actions need to send followings -> LOG_OUT for logout, FORGOT for forget password
        APIError<LoginSummary> loginMsg = adminService.login( loginDetail.getPayload(), actions );

        if( loginMsg._isSuccess() )
        {
            return ResponseEntity.
                           status( HttpStatus.OK ).
                           headers( getResponseHeaders() ).
                           body( loginMsg );
        }
        else
        {
            return ResponseEntity.
                           status( HttpStatus.INTERNAL_SERVER_ERROR ).
                           headers( getResponseHeaders() ).
                           body( loginMsg );
        }

    }

    @RequestMapping( value = "/setup/user-profiles/{profileId}", method = RequestMethod.PUT, headers = "Accept=application/json" )
    public ResponseEntity<APIError<Profile>> updateProfile( @RequestBody RequestWrapper<Profile> profile, @PathVariable( name = "profileId" ) Long profileId )
    {
        APIError<Profile> newProfile = adminService.updateProfile( profile.getPayload(), profileId );

        if( newProfile._isSuccess() )
        {
            return ResponseEntity.
                           status( HttpStatus.OK ).
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

    @RequestMapping( value = "/setup/user-profiles/{profileId}", method = RequestMethod.DELETE, headers = "Accept=application/json" )
    public ResponseEntity<APIError> deleteProfile( @PathVariable( name = "profileId" ) Long profileId )
    {
        APIError error = adminService.deleteProfile( profileId );

        if( error._isSuccess() )
        {
            return ResponseEntity.
                           status( HttpStatus.OK ).
                           headers( getResponseHeaders() ).
                           body( error );
        }
        else
        {
            return ResponseEntity.
                           status( HttpStatus.INTERNAL_SERVER_ERROR ).
                           headers( getResponseHeaders() ).
                           body( error );
        }

    }
}
