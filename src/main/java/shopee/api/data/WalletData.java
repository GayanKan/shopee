package shopee.api.data;

import jakarta.persistence.*;

import java.io.Serializable;
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

    private double balance;

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
}
