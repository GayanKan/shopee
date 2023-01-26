package shopee.api.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shopee.api.data.ProfileData;
import shopee.api.service.impl.AdminServiceImpl;

@RestController
public class AdminServiceController
{
    @Autowired
    private AdminServiceImpl adminService;

    @GetMapping( "/user-profiles/{profileId}" )
    public ProfileData getProfileById( @PathVariable( name = "profileId", required = true ) Long profileId )
    {
        return adminService.getDetailUserProfile( profileId );
    }

    @GetMapping( "/greeting" )
    public String greeting( @RequestParam( name = "name", required = false, defaultValue = "World" ) String name )
    {
        return "greetings";
    }
}
