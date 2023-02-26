package shopee.api.util;

import java.io.Serializable;

public class RequestWrapper<T> implements Serializable
{
    private T payload;

    public RequestWrapper()
    {
    }

    public RequestWrapper( T payload )
    {
        this.payload = payload;
    }

    public T getPayload()
    {
        return payload;
    }

    public void setPayload( T payload )
    {
        this.payload = payload;
    }
}
