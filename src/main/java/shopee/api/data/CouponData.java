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
public class CouponData implements Serializable
{
    @Id
    @GeneratedValue
    private Long id;

    @Column( nullable = false )
    private String name;

    private float rate;

}
