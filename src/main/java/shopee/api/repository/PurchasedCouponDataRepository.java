package shopee.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import shopee.api.data.PurchasedCouponData;

import java.util.List;
import java.util.Optional;

public interface PurchasedCouponDataRepository extends JpaRepository<PurchasedCouponData,Long>
{
    @Query(
            value = "SELECT PCD.* FROM WALLET_DATA WD, PURCHASED_COUPON_DATA PCD " +
                            "WHERE WD.PROFILE_ID = ?1 AND PCD.WALLET_ID = WD.WALLET_ID ",
            nativeQuery = true )
    List<PurchasedCouponData> getPartnerPurchaseCoupons( Long partnerId );
}