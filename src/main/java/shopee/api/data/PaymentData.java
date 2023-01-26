package shopee.api.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PaymentData implements Serializable
{
    @Id
    @GeneratedValue
    private Long paymentId;

    private String paymentReference;

    private String paymentGateway;

    private double paymentAmount;

    private String transactionReference;

    private String cardNumber; // after encrypting

    @MapsId("couponId")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "couponId", referencedColumnName = "couponId")
    private PurchasedCouponData purchasedCoupon;

}
