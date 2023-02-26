package shopee.api.library;


import java.io.Serializable;
import java.sql.Date;

public class CouponPurchase implements Serializable
{
    private Long id;

    private Coupon coupon;

    private PaymentInfo paymentInfo;

    public CouponPurchase()
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

    public Coupon getCoupon()
    {
        return coupon;
    }

    public void setCoupon( Coupon coupon )
    {
        this.coupon = coupon;
    }

    public PaymentInfo getPaymentInfo()
    {
        return paymentInfo;
    }

    public void setPaymentInfo( PaymentInfo paymentInfo )
    {
        this.paymentInfo = paymentInfo;
    }
}
