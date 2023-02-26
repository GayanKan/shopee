package shopee.api.util;

import shopee.api.library.Profile;
import shopee.api.library.ProfileCategory;


public class UserProfileValidator
{
    public static APIError validate( Profile profile )
    {
        return validateMandatoryFields( profile );
    }

    private static APIError validateMandatoryFields( Profile profile )
    {
        if( profile == null )
        {
            return new APIError( APIError.ERROR, " Cannot sent empty Payload" );
        }
        else if( profile.getAge() <= 0 )
        {
            new APIError( APIError.ERROR, "Please provide a valid age" );
        }
        else if( profile.getAge() < 18 )
        {
            new APIError( APIError.ERROR, "Please provide a valid age, age should be above 18" );
        }
        else if( profile.getCategory() == null || profile.getCategory().isEmpty() )
        {
            new APIError( APIError.ERROR,  "Profile category must be specified" );
        }
        else if( !profile.getCategory().equals( ProfileCategory.ADMIN ) || !profile.getCategory().equals( ProfileCategory.PARTNER ) || !profile.getCategory().equals( ProfileCategory.CUSTOMER ) )
        {
            new APIError( APIError.ERROR, "Please provide a valid profile category" );
        }
        else if( isNullOrEmpty( profile.getEmail() ) )
        {
            new APIError( APIError.ERROR,  "Please provide a valid email" );
        }
        else if( isNullOrEmpty( profile.getLanguage() ) )
        {
            new APIError( APIError.ERROR,  "Please provide a valid language" );
        }
        else if( isNullOrEmpty( profile.getFirstName() ) )
        {
            new APIError( APIError.ERROR,  "User Firstname cannot be empty" );
        }
        else if( isNullOrEmpty( profile.getLastName() ) )
        {
            new APIError( APIError.ERROR,  "User Lastname cannot be empty" );
        }
        else if( isNullOrEmpty( profile.getUserName() ) )
        {
            new APIError( APIError.ERROR, "Username cannot be empty" );
        }
        else if( isNullOrEmpty( profile.getUserAuthKey() ) )
        {
            new APIError( APIError.ERROR,  "UserAuth cannot be empty" );
        }
        else if( isNullOrEmpty( profile.getMobileNumber() ) )
        {
            new APIError( APIError.ERROR, "User mobile number cannot be empty" );
        }

        return new APIError( APIError.SUCCESS,  "Validation Success" );

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
