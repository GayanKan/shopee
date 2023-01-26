package shopee.api.service;

import shopee.api.data.ProfileData;

public interface IAdminService
{
    public ProfileData getDetailUserProfile( Long profileId );
}
