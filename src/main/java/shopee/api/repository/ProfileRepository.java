package shopee.api.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import shopee.api.data.ProfileData;

public interface ProfileRepository extends PagingAndSortingRepository<ProfileData, Long>
{
    ProfileData findByProfileId( Long profileId);
}
