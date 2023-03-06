package shopee.api.data;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class PartnerData implements Serializable
{
    @Id
    @GeneratedValue
    private Long Id;

    @Column( nullable = false )
    private String legalName;
    @Column( nullable = false )
    private String marketingName;

    @Column( nullable = false )
    private String address;

    private String category; // Can be RETAIL, GLOSSARY, RESTAURANT, CLOTHS

    // FK with User Profile 1:1
    private Long profileId;

    @MapsId( "profileId" )
    @ManyToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "profileId", referencedColumnName = "profileId" )
    private ProfileData partnerProfile;

    public PartnerData()
    {
    }

    public Long getId()
    {
        return Id;
    }

    public void setId( Long id )
    {
        Id = id;
    }

    public String getLegalName()
    {
        return legalName;
    }

    public void setLegalName( String legalName )
    {
        this.legalName = legalName;
    }

    public String getMarketingName()
    {
        return marketingName;
    }

    public void setMarketingName( String marketingName )
    {
        this.marketingName = marketingName;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress( String address )
    {
        this.address = address;
    }

    public ProfileData getPartnerProfile()
    {
        return partnerProfile;
    }

    public void setPartnerProfile( ProfileData partnerProfile )
    {
        this.partnerProfile = partnerProfile;
    }

    public Long getProfileId()
    {
        return profileId;
    }

    public void setProfileId( Long profileId )
    {
        this.profileId = profileId;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory( String category )
    {
        this.category = category;
    }
}

