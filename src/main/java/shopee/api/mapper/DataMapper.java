package shopee.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import shopee.api.data.ProfileData;
import shopee.api.library.Profile;

import java.util.List;

@Mapper
public abstract class DataMapper
{
    public static DataMapper dataMapper = Mappers.getMapper( DataMapper.class );

    public abstract Profile mapProfile( ProfileData profileData );

    public abstract List<Profile> mapProfiles( List<ProfileData> profileDataList);
}
