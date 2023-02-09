package shopee.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shopee.api.data.WalletData;

public interface WalletDataRepository extends JpaRepository<WalletData,Long>
{
}