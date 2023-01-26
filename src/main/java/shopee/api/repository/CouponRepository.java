package shopee.api.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import shopee.api.data.CouponData;

public interface CouponRepository extends PagingAndSortingRepository<CouponData, Long>
{
}


