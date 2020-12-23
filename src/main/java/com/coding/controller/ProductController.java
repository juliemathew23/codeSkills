package com.coding.controller;

import com.coding.dto.Catalog;
import com.coding.dto.Product;
import com.coding.repository.model.SupplierProductBarcodeA;
import com.coding.repository.model.SupplierProductBarcodeB;
import com.coding.repository.model.SuppliersA;
import com.coding.repository.model.SuppliersB;
import com.coding.service.CatalogService;
import com.coding.service.ProductService;
import com.coding.service.SupplierService;
import com.coding.util.CSVUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CatalogService catalogService;

    @Autowired
    private SupplierService supplierService;

    @GetMapping("readFromCSV")
    public void populateProducts() throws FileNotFoundException {
        productService.saveProduct();
    }

    @GetMapping("getProductDetails")
    public List<Product> getSuppliers() {
        return productService.getProducts();
    }

    @PostMapping(value = "/newProduct" , consumes = "application/json", produces = "application/json")
    public void addProduct(@RequestBody Product product) {
        System.out.println(product);
        addProductPart2(product);
    }

    @GetMapping("getMergedProductList")
    public List<Catalog> getMasterCatalog() throws IOException {
        Set<String> skuSet = productService.getMasterProductList();
        List<Catalog> mergedCatalog = catalogService.getMasterCatalog(skuSet);
        CSVUtil.writeOutputToCSV(mergedCatalog);

        return mergedCatalog;
    }

    @PostMapping(value = "/newSupplier" , consumes = "application/json", produces = "application/json")
    public void newSupplier(@RequestParam String supplierName, @RequestParam String company, @RequestParam String sku, @RequestParam int numOfProducts){

        //BarCode generator, depending on the number or products, generates a list of barcodes
        Set<String> barcodes = new HashSet<>();
        barcodes.add("1234");
        barcodes.add("2345");

        switch(company) {
            case "companyA":
                SuppliersA suppliersA = supplierService.addSupplierA(supplierName);
                barcodes.forEach(barcode -> productService.addProductA(new Product().supplierId(suppliersA.getSupplierId()).SKU(sku).barCode(barcode)));
                break;
            case "companyB":
                SuppliersB suppliersB = supplierService.addSupplierB(supplierName);
                barcodes.forEach(barcode -> productService.addProductB(new Product().supplierId(suppliersB.getSupplierId()).SKU(sku).barCode(barcode)));
                break;
        }
    }

    private void addProductPart2(Product product) {
        String company = product.getCompany();
        switch(company) {
            case "companyA":
                SupplierProductBarcodeA supplierProductBarcodeA = productService.addProductA(product);
                catalogService.addProductA(product, supplierProductBarcodeA);
                break;
            case "companyB":
                SupplierProductBarcodeB supplierProductBarcodeB = productService.addProductB(product);
                catalogService.addProductB(product, supplierProductBarcodeB);
                break;
        }
    }
}
