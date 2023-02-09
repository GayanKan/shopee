package shopee.api.data;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class CouponData implements Serializable
{
    @Id
    @GeneratedValue
    private Long id;

    @Column( nullable = false )
    private String name;

    private float rate;

    private String termsAndConditions;

    public CouponData()
    {
    }

    public Long getId()
    {
        return id;
    }

    public void setId( Long id )
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public float getRate()
    {
        return rate;
    }

    public void setRate( float rate )
    {
        this.rate = rate;
    }

    public String getTermsAndConditions()
    {
        return termsAndConditions;
    }

    public void setTermsAndConditions( String termsAndConditions )
    {
        this.termsAndConditions = termsAndConditions;
    }
}
