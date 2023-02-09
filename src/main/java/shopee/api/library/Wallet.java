package shopee.api.library;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

public class Wallet implements Serializable
{
    private Long walletId;

    private double balance;

    private List<PurchasedCoupon> purchasedCouponList;

    public Wallet()
    {
    }

    public Long getWalletId()
    {
        return walletId;
    }

    public void setWalletId( Long walletId )
    {
        this.walletId = walletId;
    }

    public double getBalance()
    {
        return balance;
    }

    public void setBalance( double balance )
    {
        this.balance = balance;
    }

    public List<PurchasedCoupon> getPurchasedCouponList()
    {
        return purchasedCouponList;
    }

    public void setPurchasedCouponList( List<PurchasedCoupon> purchasedCouponList )
    {
        this.purchasedCouponList = purchasedCouponList;
    }
}
