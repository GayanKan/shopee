package shopee.api.util;

public class APIError<T>
{
    public static int SUCCESS = 0;
    public static int WARNING = -1;
    public static int ERROR = -2;
    private int no;

    private Object data;

    private String msg;

    public APIError()
    {
    }

    public APIError( int index, Object data, String errorMsg )
    {
        this.no = index;
        this.data = data;
        this.msg = errorMsg;
    }

    public int getNo()
    {
        return no;
    }

    public void setNo( int no )
    {
        this.no = no;
    }

    public Object getData()
    {
        return data;
    }

    public void setData( Object data )
    {
        this.data = data;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg( String msg )
    {
        this.msg = msg;
    }

    public boolean _isSuccess()
    {
        return no == SUCCESS;
    }

    public boolean _isError()
    {
        return no == ERROR;
    }

    public boolean _isWarning()
    {
        return no == WARNING;
    }
}
