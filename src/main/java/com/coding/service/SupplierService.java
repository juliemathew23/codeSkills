package com.coding.service;

import com.coding.repository.SupplierARepository;
import com.coding.repository.SupplierBRepository;
import com.coding.repository.model.*;
import com.coding.util.CSVUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class SupplierService {

    private final SupplierARepository supplierARepository;

    private final SupplierBRepository supplierBRepository;


    @Autowired
    public SupplierService(SupplierARepository supplierARepository, SupplierBRepository supplierBRepository) {
        this.supplierARepository = supplierARepository;
        this.supplierBRepository = supplierBRepository;
    }

    @Transactional
    public void saveSupplier() throws FileNotFoundException {
        saveSupplierADetails("suppliersA.csv");
        saveSupplierBDetails("suppliersB.csv");
    }

    private void saveSupplierADetails(String fileName) throws FileNotFoundException {
        List<Suppliers> suppliersList = getSuppliers(fileName);

        suppliersList.forEach(supplier -> {
            supplierARepository.save(new SuppliersA(supplier));
        });
    }

    private void saveSupplierBDetails(String fileName) throws FileNotFoundException {

        List<Suppliers> suppliersList = getSuppliers(fileName);

        suppliersList.forEach(supplier -> {
            supplierBRepository.save(new SuppliersB(supplier));
        });
    }

    private List<Suppliers> getSuppliers(String fileName) throws FileNotFoundException {
        InputStream in = CSVUtil.getInputStream(fileName);
        return CSVUtil.readSuppliers(in);
    }

    public List<Suppliers> getSuppliers(){
        List<Suppliers> suppliers = new ArrayList<>();
        getSuppliersA().forEach(suppliers1 -> suppliers.add(suppliers1));
        getSuppliersB().forEach(suppliers1 -> suppliers.add(suppliers1));

        return suppliers;
    }

    public List<Suppliers> getSuppliersA(){
        return toSuppliersA(supplierARepository.findAll());
    }

    public List<Suppliers> getSuppliersB(){
        return toSuppliersB(supplierBRepository.findAll());
    }

    private List<Suppliers> toSuppliersA(List<SuppliersA> suppliersA){
        List<Suppliers> suppliersList = new ArrayList<>();
        suppliersA.forEach(suppliersA1 -> {
            suppliersList.add(new Suppliers().name(suppliersA1.getName()).supplierId(suppliersA1.getSupplierId()));
        });

        return suppliersList;
    }

    private List<Suppliers> toSuppliersB(List<SuppliersB> suppliersB){
        List<Suppliers> suppliersList = new ArrayList<>();
        suppliersB.forEach(suppliersA1 -> {
            suppliersList.add(new Suppliers().name(suppliersA1.getName()).supplierId(suppliersA1.getSupplierId()));
        });

        return suppliersList;
    }

    public SuppliersA addSupplierA(String name) {

        //Need to add @Generator to generate id's
        String suppId = "0010";
        SuppliersA suppliersA = supplierARepository.save(new SuppliersA().name(name).supplierId(suppId));
        return suppliersA;
    }

    public SuppliersB addSupplierB(String name) {
        String suppId = "0010";
        SuppliersB suppliersB = supplierBRepository.save(new SuppliersB().name(name).supplierId(suppId));
        return suppliersB;
    }
}
