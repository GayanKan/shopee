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
    private Date purchasedDate;

    private Date paidDate;

    @Column( nullable = false )
    private boolean paid;
    private float discountPercentage;

    // FK with User Profile M:1

    private Long walletId;

    @MapsId( "walletId" )
    @ManyToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "walletId", referencedColumnName = "walletId" )
    private WalletData walletData;

    private Long couponId;
    @MapsId( "couponId" )
    @ManyToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "couponId", referencedColumnName = "id" )
    private CouponData coupon;

    private boolean valid;

    private String qrCode;

    private String currency;

    private Long partnerProfileId;


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

    public float getDiscountPercentage()
    {
        return discountPercentage;
    }

    public void setDiscountPercentage( float discountPercentage )
    {
        this.discountPercentage = discountPercentage;
    }

    public WalletData getWalletData()
    {
        return walletData;
    }

    public void setWalletData( WalletData walletData )
    {
        this.walletData = walletData;
    }

    public String getQrCode()
    {
        return qrCode;
    }

    public void setQrCode( String qrCode )
    {
        this.qrCode = qrCode;
    }

    public CouponData getCoupon()
    {
        return coupon;
    }

    public void setCoupon( CouponData coupon )
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

    public Long getWalletId()
    {
        return walletId;
    }

    public void setWalletId( Long walletId )
    {
        this.walletId = walletId;
    }

    public Long getCouponId()
    {
        return couponId;
    }

    public void setCouponId( Long couponId )
    {
        this.couponId = couponId;
    }

    public String getCurrency()
    {
        return currency;
    }

    public void setCurrency( String currency )
    {
        this.currency = currency;
    }

    public Long getPartnerProfileId()
    {
        return partnerProfileId;
    }

    public void setPartnerProfileId( Long partnerProfileId )
    {
        this.partnerProfileId = partnerProfileId;
    }

    public String  getCouponDetailLink( )
    {
        return "/purchase-service/wallet/"+ this.walletData.getWalletId() + "/coupons/" + this.id;
    }
}
