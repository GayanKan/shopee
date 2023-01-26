package shopee.api.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PartnerData implements Serializable
{
    @Id
    @GeneratedValue
    private Long Id;

    @Column( nullable = false )
    private String legalName;
    @Column( nullable = false )
    private String marketingName;

    @Column( nullable = false )
    private String address;

    // FK with User Profile 1:1
    @MapsId( "profileId" )
    @ManyToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "profileId", referencedColumnName = "profileId" )
    private ProfileData partnerProfile;


}

