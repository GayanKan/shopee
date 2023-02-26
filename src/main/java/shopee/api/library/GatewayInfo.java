package shopee.api.library;


import java.io.Serializable;

public class GatewayInfo implements Serializable
{
    private String type;

    private String cardNumber;


    public String getType()
    {
        return type;
    }

    public void setType( String type )
    {
        this.type = type;
    }

    public String getCardNumber()
    {
        return cardNumber;
    }

    public void setCardNumber( String cardNumber )
    {
        this.cardNumber = cardNumber;
    }
}
