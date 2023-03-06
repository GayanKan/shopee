package shopee.api.library;

import java.io.Serializable;

public class CodeValuePair implements Serializable
{
    private String code;

    private String value;

    public CodeValuePair()
    {
    }

    public CodeValuePair( String code, String value )
    {
        this.code = code;
        this.value = value;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode( String code )
    {
        this.code = code;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue( String value )
    {
        this.value = value;
    }
}
