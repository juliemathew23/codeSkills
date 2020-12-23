package com.coding.controller;

import com.coding.dto.Catalog;
import com.coding.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("catalog")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    @GetMapping("readFromCSV")
    public void populateProducts() throws FileNotFoundException {
        catalogService.saveCatalog();
    }

    @GetMapping("getCatalogService")
    public List<Catalog> getSuppliers() {
        return catalogService.getCatalog();
    }

    @DeleteMapping("deleteProduct")
    public void deleteProductFromCatalog(@RequestParam String company, @RequestParam String SKU){
        catalogService.deleteProductFromCatalog(company, SKU);
    }

}
