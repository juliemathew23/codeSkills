package com.coding.repository.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "supplierProductBarcodeA", uniqueConstraints = {@UniqueConstraint(columnNames = { "supplierId", "SKU", "barcode" }) })
public class SupplierProductBarcodeA{

    @EmbeddedId
    private BKey primaryKey;

    @MapsId("productA")
    @ManyToOne(optional = false)
    @JoinColumns(value = {
            @JoinColumn(name = "supplierId", referencedColumnName = "supplierId")})
    protected SuppliersA suppliersA;


    public SupplierProductBarcodeA() {
    }

    public SupplierProductBarcodeA(BKey primaryKey, SuppliersA suppliersA) {
        this.primaryKey = primaryKey;
        this.suppliersA = suppliersA;
    }

    public SuppliersA getSuppliersA() {
        return suppliersA;
    }

    public void setSuppliersA(SuppliersA suppliersA) {
        this.suppliersA = suppliersA;
    }

    public BKey getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(BKey primaryKey) {
        this.primaryKey = primaryKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SupplierProductBarcodeA that = (SupplierProductBarcodeA) o;
        return Objects.equals(primaryKey, that.primaryKey) &&
                Objects.equals(suppliersA, that.suppliersA);
    }

    @Override
    public int hashCode() {
        return Objects.hash(primaryKey, suppliersA);
    }

    @Override
    public String toString() {
        return "SupplierProductBarcodeA{" +
                "primaryKey=" + primaryKey +
                ", suppliersA=" + suppliersA +
                '}';
    }
}
