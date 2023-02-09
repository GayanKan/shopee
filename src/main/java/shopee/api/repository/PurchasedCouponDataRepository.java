package shopee.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shopee.api.data.PurchasedCouponData;

public interface PurchasedCouponDataRepository extends JpaRepository<PurchasedCouponData,Long>
{
}