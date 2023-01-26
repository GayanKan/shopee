package shopee.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shopee.api.data.PartnerData;

public interface PartnerRepository extends JpaRepository<PartnerData, Long> {
}