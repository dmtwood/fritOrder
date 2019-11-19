package be.vdab;

import java.math.BigDecimal;

public class OrderLine {
    protected Producten productInOrderLine;
    protected BigDecimal numberOrderedOfThisItem=BigDecimal.ZERO;
    protected BigDecimal subTotalOfThisItem = BigDecimal.ZERO;

    OrderLine(Producten prodInOrderLine, BigDecimal numberOrderedOfThisProduct){
        setProductInOrderLine(prodInOrderLine);
        setNumberOrderedOfThisItem(numberOrderedOfThisProduct);
        getSubTotalOfThisItem();
    }


    public Producten getProductInOrderLine() {
        return productInOrderLine;
    }

    public void setProductInOrderLine(Producten productInOrderLine) {
        this.productInOrderLine = productInOrderLine;
    }

    public BigDecimal getNumberOrderedOfThisItem() {
        return numberOrderedOfThisItem;
    }

    public void setNumberOrderedOfThisItem(BigDecimal numberOrderedOfThisItem) {
        this.numberOrderedOfThisItem = numberOrderedOfThisItem;
    }

    public  BigDecimal getSubTotalOfThisItem() {
        return subTotalOfThisItem = getProductInOrderLine().getBdProductPrijs().multiply(this.numberOrderedOfThisItem);
    }

    public void setSubTotalOfThisItem() {
        this.subTotalOfThisItem = getProductInOrderLine().getBdProductPrijs().multiply(this.numberOrderedOfThisItem);
    }



}


