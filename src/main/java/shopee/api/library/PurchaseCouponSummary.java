package shopee.api.library;

import java.io.Serializable;
import java.sql.Date;

public class PurchaseCouponSummary implements Serializable
{
    private Date paidDate;

    private double amount;

    public PurchaseCouponSummary()
    {
    }

    public Date getPaidDate()
    {
        return paidDate;
    }

    public void setPaidDate( Date paidDate )
    {
        this.paidDate = paidDate;
    }

    public double getAmount()
    {
        return amount;
    }

    public void setAmount( double amount )
    {
        this.amount = amount;
    }
}
