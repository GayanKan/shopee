package shopee.api.library;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class Payment implements Serializable
{
    private Long paymentId;

    private String paymentReference;

    private String paymentGateway;

    private double paymentAmount;

    private String transactionReference;

    private String cardNumber; // after encrypting

}
