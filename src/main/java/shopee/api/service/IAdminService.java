package shopee.api.service;

import shopee.api.library.*;
import shopee.api.util.APIError;

import java.util.List;

public interface IAdminService
{
    public APIError<Profile> getDetailUserProfile( Long profileId );

    public APIError<Profile> addNewProfile( Profile profile );

    public APIError<Profile> updateProfile( Profile profile, Long profileId );

    public APIError deleteProfile( Long profileId );

    APIError<LoginSummary> login( LoginDetail loginDetail, String actions );

}
