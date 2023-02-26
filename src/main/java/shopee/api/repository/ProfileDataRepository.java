package shopee.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import shopee.api.data.ProfileData;

import java.util.Optional;

public interface ProfileDataRepository extends JpaRepository<ProfileData,Long>
{
    @Query(
            value = "SELECT * FROM PROFILE_DATA" +
                            " WHERE USER_NAME = ?1", nativeQuery = true)
    Optional<ProfileData> findByUserName( String username );

    @Query(
            value = "SELECT * FROM PROFILE_DATA" +
                            " WHERE EMAIL = ?1", nativeQuery = true)
    Optional<ProfileData> findByEmail( String email );

    @Query(
            value = "SELECT * FROM PROFILE_DATA" +
                            " WHERE MOBILE_NUMBER = ?1", nativeQuery = true)
    Optional<ProfileData> findByMobileNumber( String mobileNumber );
}