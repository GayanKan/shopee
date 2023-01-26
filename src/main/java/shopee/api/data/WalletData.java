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
public class WalletData implements Serializable
{
    @Id
    @GeneratedValue
    private Long walletId;

    @MapsId("profileId")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profileId", referencedColumnName = "profileId")
    private ProfileData partnerProfile;
}
