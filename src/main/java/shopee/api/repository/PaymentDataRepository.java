package shopee.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import shopee.api.data.PaymentData;
import shopee.api.data.PurchasedCouponData;

import java.util.List;
import java.util.Optional;

public interface PaymentDataRepository extends JpaRepository<PaymentData,Long>
{
    @Query(
            value = "SELECT * FROM PAYMENT_DATA WHERE PURCHASED_COUPON_ID = ?1", nativeQuery = true)
    Optional<PaymentData> getDetailCouponPayments( Long purchasedCouponId );
}