package shopee.api.library;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

public class Partner implements Serializable
{
    private Long Id;

    private String legalName;
    private String marketingName;

    private String address;

    private Profile partnerProfile;

    public Partner()
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

    public Profile getPartnerProfile()
    {
        return partnerProfile;
    }

    public void setPartnerProfile( Profile partnerProfile )
    {
        this.partnerProfile = partnerProfile;
    }
}

