package shopee.starter.shopee.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shopee.starter.shopee.data.Profile;
import shopee.starter.shopee.repository.ProfileRepository;

@RestController
public class AdminServiceController
{

    @Autowired
    private ProfileRepository profileRepository;
    @GetMapping("/user-profiles/{profileId}")
    public Profile getProfileById(@PathVariable(name = "profileId", required = true) Long profileId )
    {
        return profileRepository.findByProfileId(profileId);
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name)
    {
        return "greetings";
    }
}
