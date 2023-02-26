package shopee.api.data;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class ProfileData implements Serializable
{
    @Id
    @GeneratedValue
    private Long profileId;

    @Column( nullable = false )
    private String firstName;
    @Column( nullable = false )
    private String lastName;

    @Column( nullable = false )
    private int age;
    @Column( nullable = false, unique = true)
    private String userName;

    @Column( nullable = false )
    private String userAuthKey;
    @Column( unique = true )
    private String email;
    @Column( unique = true )
    private String mobileNumber;

    @Column( nullable = false )
    private String language;

    @Column( nullable = false )
    private String category; // can be a customer, partner, admin user


    public ProfileData()
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
}

