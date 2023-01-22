package shopee.starter.shopee.data;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;

@Entity
public class PurchasedCoupon implements Serializable
{
    @Id
    @GeneratedValue
    private Long id;

    private float rate;

    @Column(nullable = false)
    private Date expiryDate;
    @Column(nullable = false)
    private Date purchacedDate;
    private float discountPercentage;

    // FK with User Profile M:1
    @MapsId("profileId")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profileId", referencedColumnName = "profileId")
    private Profile partnerProfile;

    @MapsId("couponId")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "couponId", referencedColumnName = "id")
    private Coupon coupon;

    private boolean valid;

    public PurchasedCoupon() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Date getPurchacedDate() {
        return purchacedDate;
    }

    public void setPurchacedDate(Date purchacedDate) {
        this.purchacedDate = purchacedDate;
    }

    public float getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(float discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public Profile getPartnerProfile() {
        return partnerProfile;
    }

    public void setPartnerProfile(Profile partnerProfile) {
        this.partnerProfile = partnerProfile;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }
}
