package be.vdab;

import java.math.BigDecimal;
import java.util.Objects;

public class Pizza extends Producten {
    public String getsPizzaOmschrijving() {
        return sPizzaOmschrijving;
    }

    String sPizzaOmschrijving;

    public void setsPizzaOmschrijving(String sPizzaOmschrijving) {
        this.sPizzaOmschrijving = sPizzaOmschrijving;
    }

    Pizza() {
        this("","",BigDecimal.ZERO);
    }

    Pizza(String sNaamProduct, BigDecimal bdPrijsProduct) {
        this(sNaamProduct, "", bdPrijsProduct);
    }

    Pizza(String sNaamProduct, String sOmschrijvingPizza, BigDecimal bdPrijsProduct) {
        super(sNaamProduct, bdPrijsProduct);
        this.sPizzaOmschrijving = sOmschrijvingPizza;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return sProductNaam.equals(pizza.sProductNaam);
    }

    @Override
    public String toString() {
        return sProductNaam + sPizzaOmschrijving + bdProductPrijs;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sPizzaOmschrijving);
    }
}
