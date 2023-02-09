package shopee.api.library;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

public class Payment implements Serializable
{
    private Long paymentId;

    private String paymentReference;

    private String paymentGateway;

    private double paymentAmount;

    private String transactionReference;

    private String cardNumber; // after encrypting

    public Payment()
    {
    }

    public Long getPaymentId()
    {
        return paymentId;
    }

    public void setPaymentId( Long paymentId )
    {
        this.paymentId = paymentId;
    }

    public String getPaymentReference()
    {
        return paymentReference;
    }

    public void setPaymentReference( String paymentReference )
    {
        this.paymentReference = paymentReference;
    }

    public String getPaymentGateway()
    {
        return paymentGateway;
    }

    public void setPaymentGateway( String paymentGateway )
    {
        this.paymentGateway = paymentGateway;
    }

    public double getPaymentAmount()
    {
        return paymentAmount;
    }

    public void setPaymentAmount( double paymentAmount )
    {
        this.paymentAmount = paymentAmount;
    }

    public String getTransactionReference()
    {
        return transactionReference;
    }

    public void setTransactionReference( String transactionReference )
    {
        this.transactionReference = transactionReference;
    }

    public String getCardNumber()
    {
        return cardNumber;
    }

    public void setCardNumber( String cardNumber )
    {
        this.cardNumber = cardNumber;
    }
}
