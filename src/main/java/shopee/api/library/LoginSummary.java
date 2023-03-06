package shopee.api.library;

import java.io.Serializable;

public class LoginSummary implements Serializable
{
    private Long profileId;

    private String profileCategory;

    public LoginSummary()
    {
    }

    public LoginSummary( Long profileId, String profileCategory )
    {
        this.profileId = profileId;
        this.profileCategory = profileCategory;
    }

    public Long getProfileId()
    {
        return profileId;
    }

    public void setProfileId( Long profileId )
    {
        this.profileId = profileId;
    }

    public String getProfileCategory()
    {
        return profileCategory;
    }

    public void setProfileCategory( String profileCategory )
    {
        this.profileCategory = profileCategory;
    }
}
