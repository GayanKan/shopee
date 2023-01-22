package shopee.starter.shopee.repository;

import jakarta.persistence.NamedNativeQueries;
import org.springframework.data.repository.PagingAndSortingRepository;
import shopee.starter.shopee.data.Coupon;
import shopee.starter.shopee.data.Profile;

import java.util.List;

public interface CouponRepository extends PagingAndSortingRepository<Coupon, Long>
{
}


