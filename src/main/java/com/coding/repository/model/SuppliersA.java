package com.coding.repository.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "suppliersA")
public class SuppliersA extends Suppliers{

    public SuppliersA(){
        super();
    }

    public SuppliersA(String supplierId) {
        super();
        this.supplierId = supplierId;
    }

    public SuppliersA(String supplierId, String name) {
        super(supplierId, name);
    }

    public SuppliersA(Suppliers suppliers) {
        super(suppliers.supplierId, suppliers.name);
    }

    @Id
    @Column(name = "supplierId")
    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    @Column(name = "name")
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
        SuppliersA supplier = (SuppliersA) o;
        return supplierId == supplier.supplierId &&
                Objects.equals(name, supplier.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(supplierId, name);
    }

    @Override
    public String toString() {
        return "SuppliersA{" +
                "supplierId=" + supplierId +
                ", name='" + name + '\'' +
                '}';
    }

    public SuppliersA supplierId(String supplierId){
        this.supplierId = supplierId;
        return this;
    }

    public SuppliersA name(String name){
        this.name = name;
        return this;
    }
}
