package com.coding.repository.model;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "Company")
@Table(name = "Company")
public class Company {

    @Id
    @GeneratedValue
    private int companyId;

    @Column
    private String name;

    public Company(){

    }

    public Company(int companyId, String name) {
        this.companyId = companyId;
        this.name = name;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
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
        Company company = (Company) o;
        return companyId == company.companyId &&
                Objects.equals(name, company.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyId, name);
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", name='" + name + '\'' +
                '}';
    }
}
