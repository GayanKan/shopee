package shopee.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import shopee.api.data.PurchasedCouponData;

import java.util.List;
import java.util.Optional;

public interface PurchasedCouponDataRepository extends JpaRepository<PurchasedCouponData,Long>
{
    @Query(
            value = "SELECT PCD.* FROM PURCHASED_COUPON_DATA PCD " +
                            "WHERE PCD.PARTNER_PROFILE_ID = ?1 ",
            nativeQuery = true )
    List<PurchasedCouponData> getPartnerPurchaseCoupons( Long partnerId );
}