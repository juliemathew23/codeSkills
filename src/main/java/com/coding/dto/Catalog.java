package com.coding.dto;

import com.coding.service.Company;

public class Catalog {

    private String SKU;

    private String description;

    private Company company;

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Catalog SKU(String SKU){
        this.SKU = SKU;
        return this;
    }

    public Catalog description(String description){
        this.description = description;
        return this;
    }

    public Catalog company(Company company){
        this.company = company;
        return this;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
