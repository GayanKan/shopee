package shopee.api;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ShopeeApplication extends SpringBootServletInitializer
{
    /**
     * Used when run as JAR
     */
    public static void main( String[] args )
    {
        SpringApplication.run( ShopeeApplication.class, args );
    }

    /**
     * Used when run as WAR
     */
    @Override
    protected SpringApplicationBuilder configure( SpringApplicationBuilder builder )
    {
        return builder.sources( ShopeeApplication.class );
    }

    private static SpringApplicationBuilder customizerBuilder( SpringApplicationBuilder builder )
    {
        return builder.sources( ShopeeApplication.class ).bannerMode( Banner.Mode.OFF );
    }
}
