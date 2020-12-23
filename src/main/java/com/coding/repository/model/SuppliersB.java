package com.coding.repository.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "suppliersB")
public class SuppliersB extends Suppliers{

    @Id
    protected String supplierId;

    @Column
    protected String name;

    public SuppliersB(){

    }

    public SuppliersB(String supplierId) {
        this.supplierId = supplierId;
    }

    public SuppliersB(String supplierId, String name){
        this.supplierId = supplierId;
        this.name = name;
    }

    public SuppliersB(Suppliers suppliers) {
        this.supplierId = suppliers.supplierId;
        this.name = suppliers.name;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuppliersB supplier = (SuppliersB) o;
        return supplierId == supplier.supplierId &&
                Objects.equals(name, supplier.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(supplierId, name);
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierId=" + supplierId +
                ", name='" + name + '\'' +
                '}';
    }

    public SuppliersB supplierId(String supplierId){
        this.supplierId = supplierId;
        return this;
    }

    public SuppliersB name(String name){
        this.name = name;
        return this;
    }
}
