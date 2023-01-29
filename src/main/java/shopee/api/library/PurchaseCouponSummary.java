package shopee.api.library;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
public class PurchaseCouponSummary
{
    private Long id;

    private Date paidDate;

    private float amount;
}
