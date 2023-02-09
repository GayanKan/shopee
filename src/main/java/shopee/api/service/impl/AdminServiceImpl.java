package shopee.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shopee.api.library.LoginDetail;
import shopee.api.library.Profile;
import shopee.api.mapper.DataMapper;
import shopee.api.repository.ProfileRepository;
import shopee.api.service.IAdminService;
import shopee.api.data.ProfileData;
import shopee.api.util.APIError;

import java.util.Optional;

@Service
@Scope("prototype")
public class AdminServiceImpl implements IAdminService
{
    @Autowired
    ProfileRepository partnerRepository;

    @Transactional(readOnly = true)
    @Override
    public APIError<Profile> getDetailUserProfile( Long profileId )
    {
        APIError apiError = new APIError(APIError.SUCCESS, new Object(), "Profile Found Success");
        Optional<ProfileData> profileData = partnerRepository.findByProfileId( profileId );
        if( profileData.isPresent() )
        {
            Profile profile = DataMapper.dataMapper.mapProfile( profileData.get() );
            apiError.setData( profile );
        }
        else
        {
            apiError = new APIError(APIError.ERROR, null, "Profile Not Found for the given profile id");
        }
       return apiError;
    }

    public APIError<Profile> addNewProfile( Profile profile )
    {
        return null;
    }

    @Override
    public APIError<Profile> updateProfile( Profile profile, Long profileId )
    {
        return null;
    }

    @Override
    public APIError deleteProfile( Long profileId )
    {
        return null;
    }

    @Override
    public APIError login( LoginDetail loginDetail, String actions )
    {
        APIError apiError = new APIError(APIError.SUCCESS, new Object(), "Login Success");

        return apiError;
    }
}
