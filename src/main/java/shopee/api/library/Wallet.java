package shopee.api.library;


import java.io.Serializable;
import java.util.List;

public class Wallet implements Serializable
{
    private Long walletId;

    private double balance;

    private List<PurchasedCoupon> purchasedCoupons;

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

    public List<PurchasedCoupon> getPurchasedCoupons()
    {
        return purchasedCoupons;
    }

    public void setPurchasedCoupons( List<PurchasedCoupon> purchasedCoupons )
    {
        this.purchasedCoupons = purchasedCoupons;
    }
}
