package shopee.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import shopee.api.data.PurchasedCouponData;
import shopee.api.data.WalletData;

import java.util.List;
import java.util.Optional;

public interface WalletDataRepository extends JpaRepository<WalletData,Long>
{
    @Query(
            value = "SELECT WD.* FROM WALLET_DATA WD, PROFILE_DATA PD " +
                            " WHERE WD.PROFILE_ID = PD.PROFILE_ID AND PD.PROFILE_ID = ?1", nativeQuery = true)
    Optional<WalletData> getWalletByProfileId( Long profileId );
}