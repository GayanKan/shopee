package shopee.api.library;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class Profile implements Serializable
{
    private Long profileId;

    private String firstName;
    private String lastName;

    private int age;

    private String userName;

    private String userAuthKey; // Contains encrypted password

    private String email;

    private String mobileNumber;

    private String language;

    // Returns Enums of @ProfileCategory
    private String category; // can be a customer, partner, admin user


}

