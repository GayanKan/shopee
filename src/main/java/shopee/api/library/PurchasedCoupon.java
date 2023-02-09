package shopee.api.library;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;

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

    private String qrCode;

    public PurchasedCoupon()
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

    public float getDiscountRate()
    {
        return discountRate;
    }

    public void setDiscountRate( float discountRate )
    {
        this.discountRate = discountRate;
    }

    public Date getExpiryDate()
    {
        return expiryDate;
    }

    public void setExpiryDate( Date expiryDate )
    {
        this.expiryDate = expiryDate;
    }

    public Date getPurchacedDate()
    {
        return purchacedDate;
    }

    public void setPurchacedDate( Date purchacedDate )
    {
        this.purchacedDate = purchacedDate;
    }

    public Date getPaidDate()
    {
        return paidDate;
    }

    public void setPaidDate( Date paidDate )
    {
        this.paidDate = paidDate;
    }

    public boolean isPaid()
    {
        return paid;
    }

    public void setPaid( boolean paid )
    {
        this.paid = paid;
    }

    public double getDiscountPercentage()
    {
        return discountPercentage;
    }

    public void setDiscountPercentage( double discountPercentage )
    {
        this.discountPercentage = discountPercentage;
    }

    public Coupon getCoupon()
    {
        return coupon;
    }

    public void setCoupon( Coupon coupon )
    {
        this.coupon = coupon;
    }

    public Payment getCouponPayment()
    {
        return couponPayment;
    }

    public void setCouponPayment( Payment couponPayment )
    {
        this.couponPayment = couponPayment;
    }

    public boolean isValid()
    {
        return valid;
    }

    public void setValid( boolean valid )
    {
        this.valid = valid;
    }

    public String getQrCode()
    {
        return qrCode;
    }

    public void setQrCode( String qrCode )
    {
        this.qrCode = qrCode;
    }
}
