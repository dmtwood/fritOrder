package be.vdab;

import java.math.BigDecimal;

public abstract class Producten {

    String sProductNaam;
    BigDecimal bdProductPrijs;

    Producten(String sNaamProduct, BigDecimal bdPrijsProduct ){
        this.sProductNaam = sNaamProduct;
        this.bdProductPrijs = bdPrijsProduct;
    }

    public String getsProductNaam() {
        return sProductNaam;
    }

    public void setProductNaam(String sProductNaam) {
        if (!sProductNaam.trim().isEmpty())
        this.sProductNaam = sProductNaam;
    }

    public BigDecimal getBdProductPrijs() {
        return bdProductPrijs;
    }

    public void setBdProductPrijs(BigDecimal bdProductPrijs) {
        if (bdProductPrijs.compareTo(BigDecimal.ZERO) > 0)
        this.bdProductPrijs = bdProductPrijs;
    }
}
