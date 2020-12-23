package com.coding.repository.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "catalogB")
public class CatalogB{
    @Id
    @Column(name = "SKU")
    private String SKU;

    @Column(name = "description")
    private String description;

    public CatalogB() {
    }

    public CatalogB(String SKU, String description) {
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

    public CatalogB SKU(String SKU){
        this.SKU = SKU;
        return this;
    }

    public CatalogB description(String description){
        this.description = description;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CatalogB catalogB = (CatalogB) o;
        return Objects.equals(SKU, catalogB.SKU) &&
                Objects.equals(description, catalogB.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(SKU, description);
    }

    @Override
    public String toString() {
        return "CatalogB{" +
                "SKU='" + SKU + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
