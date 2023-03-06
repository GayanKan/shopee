package shopee.api.library;


import java.io.Serializable;
import java.sql.Date;

public class PurchasedCoupon implements Serializable
{
    private Long id;

    private float purchasedValue;

    private Date expiryDate;

    private Date purchasedDate;

    private Date paidDate;

    private boolean paid;
    private double discountPercentage;

    private Coupon coupon;

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

    public float getPurchasedValue()
    {
        return purchasedValue;
    }

    public void setPurchasedValue( float purchasedValue )
    {
        this.purchasedValue = purchasedValue;
    }

    public Date getExpiryDate()
    {
        return expiryDate;
    }

    public void setExpiryDate( Date expiryDate )
    {
        this.expiryDate = expiryDate;
    }

    public Date getPurchasedDate()
    {
        return purchasedDate;
    }

    public void setPurchasedDate( Date purchasedDate )
    {
        this.purchasedDate = purchasedDate;
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
