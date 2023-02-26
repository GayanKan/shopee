package shopee.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shopee.api.data.WalletData;
import shopee.api.library.LoginDetail;
import shopee.api.library.Profile;
import shopee.api.mapper.DataMapper;
import shopee.api.repository.ProfileDataRepository;
import shopee.api.repository.ProfileRepository;
import shopee.api.repository.WalletDataRepository;
import shopee.api.service.IAdminService;
import shopee.api.data.ProfileData;
import shopee.api.util.APIError;
import shopee.api.util.UserProfileValidator;

import java.util.Optional;

@Service
@Scope( "prototype" )
public class AdminServiceImpl implements IAdminService
{
    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    ProfileDataRepository profileDataRepository;

    @Autowired
    private WalletDataRepository walletDataRepository;

    @Transactional( readOnly = true )
    @Override
    public APIError<Profile> getDetailUserProfile( Long profileId )
    {
        APIError apiError = new APIError( APIError.SUCCESS, new Object(), "Profile Found Success" );
        Optional<ProfileData> profileData = profileRepository.findByProfileId( profileId );

        if( profileData.isPresent() )
        {
            Optional<WalletData> wallet = walletDataRepository.getWalletByProfileId( profileData.get().getProfileId() );
            Profile profile = DataMapper.dataMapper.mapProfile( profileData.get() );
            profile.setWalletId( wallet.isPresent() ? wallet.get().getWalletId() : -1 );
            apiError.setData( profile );
        }
        else
        {
            apiError = new APIError( APIError.ERROR, null, "Profile Not Found for the given profile id" );
        }
        return apiError;
    }

    public APIError<Profile> addNewProfile( Profile profile )
    {
        APIError apiError = new APIError( APIError.SUCCESS, "Add new Profile Success" );

        APIError error = UserProfileValidator.validate( profile );
        if( error._isSuccess() )
        {
            error = this.validateUniqueValues( profile );
            if( error._isSuccess() )
            {
                ProfileData profileData = DataMapper.dataMapper.mapProfileDTOToDAO( profile );
                profileData.setUserAuthKey( "" ); // TODO Need to Encrypt
                ProfileData profileDataNew = profileDataRepository.saveAndFlush( profileData );

                WalletData walletData = new WalletData();
                walletData.setWalletId( ( long ) -1 );
                walletData.setCurrency( "EUR" );
                walletData.setProfileId( profileDataNew.getProfileId() );
                walletData.setPartnerProfile( profileDataNew );
                walletData = walletDataRepository.saveAndFlush( walletData );

                profile = DataMapper.dataMapper.mapProfile( profileDataNew );
                profile.setWalletId( walletData.getWalletId() );

                apiError.setData( profile );
            }
            else
            {
                apiError.setMsg( error.getMsg() );
            }
        }
        else
        {
            apiError.setMsg( error.getMsg() );
        }

        return apiError;
    }

    @Override
    public APIError<Profile> updateProfile( Profile profile, Long profileId )
    {
        APIError apiError = new APIError( APIError.SUCCESS, "Profile Update Success" );
        Optional<ProfileData> profileData = profileRepository.findByProfileId( profileId );

        if( profileData.isPresent() )
        {
            ProfileData profileDataEdit = profileData.get();
            profileDataEdit.setAge( profile.getAge() );
            profileDataEdit.setFirstName( profile.getFirstName() );
            profileDataEdit.setLastName( profile.getLastName() );
            profileDataEdit.setLanguage( profile.getLanguage() );
            profileDataEdit.setUserAuthKey( profile.getUserAuthKey() ); // TODO Need to Encrypt

            ProfileData profileDataNew = profileDataRepository.saveAndFlush( profileDataEdit );
            apiError.setData( profileDataNew );
        }
        else
        {
            apiError = new APIError( APIError.ERROR, null, "Profile Not Found for the given profile id" );
        }
        return apiError;
    }

    @Override
    public APIError deleteProfile( Long profileId )
    {
        return new APIError( APIError.ERROR, null, "Profile Delete Not Implemented" );
    }

    @Override
    public APIError login( LoginDetail loginDetail, String actions )
    {
        APIError apiError = new APIError( APIError.SUCCESS, 1002, "Login Success" );


        // return user's profile id here, so can load the user profile from it.


        return apiError;
    }

    private APIError<String> validateUniqueValues( Profile profile )
    {
        Optional<ProfileData> userProfile = profileDataRepository.findByUserName( profile.getUserName() );
        if( userProfile.isPresent() )
        {
            return new APIError( APIError.ERROR, "Username already taken. Please select another username" );
        }

        userProfile = profileDataRepository.findByEmail( profile.getEmail() );
        if( userProfile.isPresent() )
        {
            return new APIError( APIError.ERROR, "User Email already exits. Please add an alternative email" );
        }

        userProfile = profileDataRepository.findByMobileNumber( profile.getMobileNumber() );
        if( userProfile.isPresent() )
        {
            return new APIError( APIError.ERROR, "User Mobile Number already exits. Please add an alternative email" );
        }

        return new APIError( APIError.SUCCESS, "Validation Success" );

    }

}
