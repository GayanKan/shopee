package shopee.api.library;

import java.io.Serializable;
import java.util.List;

public class PartnerWallet implements Serializable
{
    private double totalPaidAmount;

    private List<PurchaseCouponSummary> purchaseCouponSummaries;

    public PartnerWallet()
    {
    }

    public double getTotalPaidAmount()
    {
        return totalPaidAmount;
    }

    public void setTotalPaidAmount( double totalPaidAmount )
    {
        this.totalPaidAmount = totalPaidAmount;
    }

    public List<PurchaseCouponSummary> getPurchaseCouponSummaries()
    {
        return purchaseCouponSummaries;
    }

    public void setPurchaseCouponSummaries( List<PurchaseCouponSummary> purchaseCouponSummaries )
    {
        this.purchaseCouponSummaries = purchaseCouponSummaries;
    }
}
