package shopee.api.library;


import java.io.Serializable;

public class PaymentInfo implements Serializable
{
    private GatewayInfo gatewayInfo;

    public PaymentInfo()
    {
    }

    public GatewayInfo getGatewayInfo()
    {
        return gatewayInfo;
    }

    public void setGatewayInfo( GatewayInfo gatewayInfo )
    {
        this.gatewayInfo = gatewayInfo;
    }
}
