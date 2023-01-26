package shopee.api.library;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Wallet implements Serializable
{
    private Long walletId;

    private double balance;

    private List<PurchasedCoupon> purchasedCouponList;
}
