package shopee.api.util;

import org.springframework.http.HttpHeaders;

public class HeaderUtil
{
    public static HttpHeaders getResponseHeaders()
    {
        return getDefaultHeaders();
    }

    private static HttpHeaders getDefaultHeaders()
    {
        //Create Headers
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set( "header1", "value1" );
        responseHeaders.set( "header2", "value2" );
        return responseHeaders;
    }
}
