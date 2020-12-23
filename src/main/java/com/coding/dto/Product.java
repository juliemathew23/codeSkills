package com.coding.dto;

public class Product {

    private String supplierId;

    private String SKU;

    private String barCode;

    private String company;

    private String description;

    public Product supplierId(String supplierId){
        this.supplierId = supplierId;
        return this;
    }

    public Product SKU(String SKU){
        this.SKU = SKU;
        return this;
    }

    public Product barCode(String barCode){
        this.barCode = barCode;
        return this;
    }

    public Product company(String company){
        this.company = company;
        return this;
    }

    public Product description(String description){
        this.description = description;
        return this;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
