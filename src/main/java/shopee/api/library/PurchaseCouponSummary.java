package shopee.api.library;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

public class PurchaseCouponSummary
{
    private Long id;

    private Date paidDate;

    private float amount;

    public PurchaseCouponSummary()
    {
    }

    public Long getId()
    {
        return id;
    }

    public void setId( Long id )
    {
        this.id = id;
    }

    public Date getPaidDate()
    {
        return paidDate;
    }

    public void setPaidDate( Date paidDate )
    {
        this.paidDate = paidDate;
    }

    public float getAmount()
    {
        return amount;
    }

    public void setAmount( float amount )
    {
        this.amount = amount;
    }
}
