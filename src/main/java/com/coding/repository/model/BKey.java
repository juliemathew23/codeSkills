package com.coding.repository.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BKey implements Serializable {

    @Column(name = "SKU")
    private String SKU;

    @Column(name = "supplierId")
    private String supplierId;

    @Column(name = "barcode")
    private String barcode;

    public BKey() {
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BKey bKey = (BKey) o;
        return Objects.equals(SKU, bKey.SKU) &&
                Objects.equals(supplierId, bKey.supplierId) &&
                Objects.equals(barcode, bKey.barcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(SKU, supplierId, barcode);
    }

    @Override
    public String toString() {
        return "BKey{" +
                "SKU='" + SKU + '\'' +
                ", supplierId='" + supplierId + '\'' +
                ", barcode='" + barcode + '\'' +
                '}';
    }

    public BKey(String SKU, String supplierId, String barcode) {
        this.SKU = SKU;
        this.supplierId = supplierId;
        this.barcode = barcode;
    }


}
