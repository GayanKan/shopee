package shopee.starter.shopee.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import shopee.starter.shopee.data.Profile;

public interface ProfileRepository extends PagingAndSortingRepository<Profile, Long>
{
    Profile  findByProfileId(Long profileId);
}
