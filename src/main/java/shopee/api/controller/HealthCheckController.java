package shopee.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import shopee.api.library.Profile;
import shopee.api.util.APIError;

import java.rmi.RemoteException;

import static shopee.api.util.HeaderUtil.getResponseHeaders;

@RestController
@RequestMapping("health")
public class HealthCheckController
{
    @RequestMapping( value = "/check", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
    public ResponseEntity<String> healthCheck( )
    {
        return ResponseEntity.
                       status( HttpStatus.OK ).
                       headers( getResponseHeaders() ).
                       body( "Success" );
    }
}
