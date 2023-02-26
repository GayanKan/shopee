package shopee.api.library;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

public class Coupon implements Serializable
{
    private Long id;
    private String name;

    private String currency;

    private double rate;
    private String termsAndConditions;

    public Coupon()
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

    public double getRate()
    {
        return rate;
    }

    public void setRate( double rate )
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

    public String getCurrency()
    {
        return currency;
    }

    public void setCurrency( String currency )
    {
        this.currency = currency;
    }
}
