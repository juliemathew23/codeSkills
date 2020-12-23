package com.coding.repository.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "supplierProductBarcodeB", uniqueConstraints = {@UniqueConstraint(columnNames = { "supplierId", "SKU", "barcode" }) })
public class SupplierProductBarcodeB{

    @EmbeddedId
    private BKey primaryKey;

    @MapsId("productA")
    @ManyToOne(optional = false)
    @JoinColumns(value = {
            @JoinColumn(name = "supplierId", referencedColumnName = "supplierId")})
    private SuppliersB suppliersB;

    public SupplierProductBarcodeB() {
    }

    public BKey getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(BKey primaryKey) {
        this.primaryKey = primaryKey;
    }

    public SuppliersB getSuppliersB() {
        return suppliersB;
    }

    public void setSuppliersB(SuppliersB suppliersB) {
        this.suppliersB = suppliersB;
    }

    public SupplierProductBarcodeB(BKey primaryKey, SuppliersB suppliersB) {
        this.primaryKey = primaryKey;
        this.suppliersB = suppliersB;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SupplierProductBarcodeB that = (SupplierProductBarcodeB) o;
        return Objects.equals(primaryKey, that.primaryKey) &&
                Objects.equals(suppliersB, that.suppliersB);
    }

    @Override
    public int hashCode() {
        return Objects.hash(primaryKey, suppliersB);
    }

    @Override
    public String toString() {
        return "SupplierProductBarcodeB{" +
                "primaryKey=" + primaryKey +
                ", suppliersB=" + suppliersB +
                '}';
    }
}
