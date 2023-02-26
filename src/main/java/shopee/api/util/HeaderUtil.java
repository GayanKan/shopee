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
        responseHeaders.set( "api_key", String.valueOf( "api_key".hashCode() ) );
        return responseHeaders;
    }
}
