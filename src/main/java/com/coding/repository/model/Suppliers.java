package com.coding.repository.model;

public class Suppliers {

    protected String supplierId;

    protected String name;

    public Suppliers(String supplierId, String name) {
        this.supplierId = supplierId;
        this.name = name;
    }

    public Suppliers() {

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

    public Suppliers name(String name){
        this.name = name;
        return this;
    }

    public Suppliers supplierId(String supplierId){
        this.supplierId = supplierId;
        return this;
    }

}
