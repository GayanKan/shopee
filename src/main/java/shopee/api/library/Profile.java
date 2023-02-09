package shopee.api.library;


import java.io.Serializable;

public class Profile implements Serializable
{
    private Long profileId;

    private String firstName;
    private String lastName;

    private int age;

    private String userName;

    private String userAuthKey; // Contains encrypted password

    private String email;

    private String mobileNumber;

    private String language;

    // Returns Enums of @ProfileCategory
    private String category; // can be a customer, partner, admin user

    private Long walletId;

    public Profile()
    {
    }

    public Long getProfileId()
    {
        return profileId;
    }

    public void setProfileId( Long profileId )
    {
        this.profileId = profileId;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName( String firstName )
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName( String lastName )
    {
        this.lastName = lastName;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge( int age )
    {
        this.age = age;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName( String userName )
    {
        this.userName = userName;
    }

    public String getUserAuthKey()
    {
        return userAuthKey;
    }

    public void setUserAuthKey( String userAuthKey )
    {
        this.userAuthKey = userAuthKey;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail( String email )
    {
        this.email = email;
    }

    public String getMobileNumber()
    {
        return mobileNumber;
    }

    public void setMobileNumber( String mobileNumber )
    {
        this.mobileNumber = mobileNumber;
    }

    public String getLanguage()
    {
        return language;
    }

    public void setLanguage( String language )
    {
        this.language = language;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory( String category )
    {
        this.category = category;
    }

    public Long getWalletId()
    {
        return walletId;
    }

    public void setWalletId( Long walletId )
    {
        this.walletId = walletId;
    }
}

