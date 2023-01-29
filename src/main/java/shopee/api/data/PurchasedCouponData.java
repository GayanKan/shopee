package shopee.api.data;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;

@Entity
public class PurchasedCouponData implements Serializable
{
    @Id
    @GeneratedValue
    private Long id;

    private float rate;

    @Column( nullable = false )
    private Date expiryDate;
    @Column( nullable = false )
    private Date purchacedDate;

    @Column( nullable = false )
    private Date paidDate;

    @Column( nullable = false )
    private boolean paid;
    private float discountPercentage;

    // FK with User Profile M:1
    @MapsId( "profileId" )
    @ManyToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "profileId", referencedColumnName = "profileId" )
    private ProfileData partnerProfile;

    @MapsId( "couponId" )
    @ManyToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "couponId", referencedColumnName = "id" )
    private CouponData coupon;

    @MapsId( "paymentId" )
    @OneToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "paymentId", referencedColumnName = "paymentId" )
    private PaymentData couponPayment;

    private boolean valid;

    public PurchasedCouponData()
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

    public float getRate()
    {
        return rate;
    }

    public void setRate( float rate )
    {
        this.rate = rate;
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

    public float getDiscountPercentage()
    {
        return discountPercentage;
    }

    public void setDiscountPercentage( float discountPercentage )
    {
        this.discountPercentage = discountPercentage;
    }

    public ProfileData getPartnerProfile()
    {
        return partnerProfile;
    }

    public void setPartnerProfile( ProfileData partnerProfile )
    {
        this.partnerProfile = partnerProfile;
    }

    public CouponData getCoupon()
    {
        return coupon;
    }

    public void setCoupon( CouponData coupon )
    {
        this.coupon = coupon;
    }

    public PaymentData getCouponPayment()
    {
        return couponPayment;
    }

    public void setCouponPayment( PaymentData couponPayment )
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
}
