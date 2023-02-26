package shopee.api.util;

public class Payload<T>
{
    private Object payload;

    public Payload( Object payload )
    {
        this.payload = payload;
    }

    public Object getPayload()
    {
        return payload;
    }

    public void setPayload( Object payload )
    {
        this.payload = payload;
    }
}
