package com.coding.controller;

import com.coding.repository.model.Suppliers;
import com.coding.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping("readFromCSV")
    public void populateSuppliers() throws FileNotFoundException {
        supplierService.saveSupplier();
    }

    @GetMapping("getSupplierDetails")
    public List<Suppliers> getSuppliers() {
        return supplierService.getSuppliers();
    }


}
