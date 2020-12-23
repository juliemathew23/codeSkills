package com.coding.repository.model;

import javax.persistence.*;

@Entity
@Table(name = "catalogA")
public class CatalogA{

    @Id
    @Column(name = "SKU")
    private String SKU;

    @Column(name = "description")
    private String description;

    public CatalogA() {
    }

    public CatalogA(String SKU, String description) {
        this.SKU = SKU;
        this.description = description;
    }

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

    public CatalogA SKU(String SKU){
        this.SKU = SKU;
        return this;
    }

    public CatalogA description(String description){
        this.description = description;
        return this;
    }
}
