package shopee.api.library;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
public class PurchasedCoupon implements Serializable
{
    private Long id;

    private float discountRate;

    private Date expiryDate;

    private Date purchacedDate;

    private Date paidDate;

    private boolean paid;
    private double discountPercentage;

    private Coupon coupon;

    private Payment couponPayment;

    private boolean valid;

}
