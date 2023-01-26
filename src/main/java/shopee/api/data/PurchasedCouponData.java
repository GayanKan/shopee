package shopee.api.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
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

    @MapsId( "couponId" )
    @OneToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "couponId", referencedColumnName = "couponId" )
    private PaymentData couponPayment;

    private boolean valid;

}
