package shopee.api.util;

import shopee.api.library.CouponPurchase;
import shopee.api.library.ProfileCategory;


public class Validator
{
    public static APIError validatePurchaseCoupons( CouponPurchase coupon )
    {
        if( coupon == null || coupon.getCoupon() == null || coupon.getPaymentInfo() == null )
        {
            return new APIError( APIError.ERROR, " Missing payload mandatory nodes" );
        }
        else if( coupon.getCoupon().getId() < -1 || coupon.getCoupon().getRate() < 0 )
        {
            new APIError( APIError.ERROR, "Invalid coupon data" );
        }
        else if( coupon.getPaymentInfo().getGatewayInfo() == null )
        {
            new APIError( APIError.ERROR, "Invalid Payment gateway info" );
        }
        else if( isNullOrEmpty( coupon.getPaymentInfo().getGatewayInfo().getType() ) )
        {
            new APIError( APIError.ERROR, "Invalid Payment Gateway Type" );
        }

        return new APIError( APIError.SUCCESS, "Validation Success" );

    }

    private static boolean isNullOrEmpty( String value )
    {
        if( value == null || value.isEmpty() )
        {
            return true;
        }
        return false;
    }
}
