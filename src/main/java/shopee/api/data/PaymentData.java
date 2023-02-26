package shopee.api.data;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class PaymentData implements Serializable
{
    @Id
    @GeneratedValue
    private Long paymentId;

    private String paymentReference;

    private String paymentGateway;

    private double paymentAmount;

    private String currency;

    private String transactionReference;

    private String cardNumber; // after encrypting

    @MapsId("purchasedCouponId")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "purchasedCouponId", referencedColumnName = "id")
    private PurchasedCouponData purchasedCoupon;

    public PaymentData()
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

    public PurchasedCouponData getPurchasedCoupon()
    {
        return purchasedCoupon;
    }

    public void setPurchasedCoupon( PurchasedCouponData purchasedCoupon )
    {
        this.purchasedCoupon = purchasedCoupon;
    }
}
