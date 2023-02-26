package shopee.api.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import shopee.api.data.ProfileData;

import java.util.Optional;

public interface ProfileRepository extends PagingAndSortingRepository<ProfileData, Long>
{
    Optional<ProfileData> findByProfileId( Long profileId);
}
