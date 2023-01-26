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
public class ProfileData implements Serializable
{
    @Id
    @GeneratedValue
    private Long profileId;

    @Column( nullable = false )
    private String firstName;
    @Column( nullable = false )
    private String lastName;

    @Column( nullable = false )
    private int age;
    @Column( nullable = false )
    private String userName;
    @Column( unique = true )
    private String email;
    @Column( unique = true )
    private String mobileNumber;

    @Column( nullable = false )
    private String language;

    @Column( nullable = false )
    private String category; // can be a customer, partner, admin user

    @MapsId( "walletId" )
    @OneToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "walletId", referencedColumnName = "id" )
    private WalletData coupon;

}

