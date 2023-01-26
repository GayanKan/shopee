package shopee.api.library;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class Partner implements Serializable
{
    private Long Id;

    private String legalName;
    private String marketingName;

    private String address;

    private Profile partnerProfile;


}

