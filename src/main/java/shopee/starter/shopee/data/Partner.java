package shopee.starter.shopee.data;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Partner implements Serializable
{
    @Id
    @GeneratedValue
    private Long Id;

    @Column(nullable = false)
    private String legalName;
    @Column(nullable = false)
    private String marketingName;

    @Column(nullable = false)
    private String address;

    // FK with User Profile 1:1
    @MapsId("profileId")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profileId", referencedColumnName = "profileId")
    private Profile partnerProfile;


    public Partner() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getMarketingName() {
        return marketingName;
    }

    public void setMarketingName(String marketingName) {
        this.marketingName = marketingName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Profile getPartnerProfile() {
        return partnerProfile;
    }

    public void setPartnerProfile(Profile partnerProfile) {
        this.partnerProfile = partnerProfile;
    }
}

