package shopee.api.data;

import jakarta.persistence.*;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;

import java.io.Serializable;
import java.util.List;

@Entity
public class WalletData implements Serializable
{
    @Id
    @GeneratedValue
    private Long walletId;

    @MapsId("profileId")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profileId", referencedColumnName = "profileId")
    private ProfileData partnerProfile;

    @MapsId("walletId")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "walletId", referencedColumnName = "walletId")
    private List<PurchasedCouponData> purchasedCouponData;

    private double balance;

    private String currency;

    public WalletData()
    {
    }

    public Long getWalletId()
    {
        return walletId;
    }

    public void setWalletId( Long walletId )
    {
        this.walletId = walletId;
    }

    public ProfileData getPartnerProfile()
    {
        return partnerProfile;
    }

    public void setPartnerProfile( ProfileData partnerProfile )
    {
        this.partnerProfile = partnerProfile;
    }

    public double getBalance()
    {
        return balance;
    }

    public void setBalance( double balance )
    {
        this.balance = balance;
    }

    public String getCurrency()
    {
        return currency;
    }

    public void setCurrency( String currency )
    {
        this.currency = currency;
    }

    public List<PurchasedCouponData> getPurchasedCouponData()
    {
        return purchasedCouponData;
    }

    public void setPurchasedCouponData( List<PurchasedCouponData> purchasedCouponData )
    {
        this.purchasedCouponData = purchasedCouponData;
    }
}
