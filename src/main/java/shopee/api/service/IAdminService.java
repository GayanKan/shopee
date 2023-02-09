package shopee.api.service;

import shopee.api.library.LoginDetail;
import shopee.api.library.Profile;
import shopee.api.util.APIError;

public interface IAdminService
{
    public APIError<Profile> getDetailUserProfile( Long profileId );

    public APIError<Profile> addNewProfile( Profile profile );

    public APIError<Profile> updateProfile( Profile profile, Long profileId );

    public APIError deleteProfile( Long profileId );

    APIError login( LoginDetail loginDetail, String actions );
}
