package com.coding.service;

import com.coding.dto.Catalog;
import com.coding.dto.Product;
import com.coding.repository.CatalogARepository;
import com.coding.repository.CatalogBRepository;
import com.coding.repository.model.*;
import com.coding.util.CSVUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

@Service
public class CatalogService {

    private final CatalogARepository catalogARepository;

    private final CatalogBRepository catalogBRepository;

    @Autowired
    public CatalogService(CatalogARepository catalogARepository, CatalogBRepository catalogBRepository) {
        this.catalogARepository = catalogARepository;
        this.catalogBRepository = catalogBRepository;
    }

    @Transactional
    public void saveCatalog() throws FileNotFoundException {
        InputStream in = CSVUtil.getInputStream("catalogA.csv");
        List<CatalogA> productsA = CSVUtil.readCatalogA(in);
        productsA.forEach(product -> {
            catalogARepository.save(product);
        });

        InputStream inB = CSVUtil.getInputStream("catalogB.csv");
        List<CatalogB> productsB = CSVUtil.readCatalogB(inB);
        productsB.forEach(product -> {
            catalogBRepository.save(product);
        });
    }

    public List<Catalog> getCatalog() {
        List<Catalog> catalog = new ArrayList<>();
        List<CatalogA> catalogA = catalogARepository.findAll();
        List<CatalogB> catalogB = catalogBRepository.findAll();

        catalogA.forEach(catalogA1 -> {
            catalog.add(new Catalog().SKU(catalogA1.getSKU()).description(catalogA1.getDescription()));
        });

        catalogB.forEach(catalogB1 -> {
            catalog.add(new Catalog().SKU(catalogB1.getSKU()).description(catalogB1.getDescription()));
        });

        System.out.println("Products size: " + catalog.size());
        return catalog;
    }


    public void addProductB(Product product, SupplierProductBarcodeB supplierProductBarcodeB) {
        CatalogB productB = new CatalogB();
        productB.setDescription(product.getDescription());
        productB.setSKU(supplierProductBarcodeB.getPrimaryKey().getSKU());

        catalogBRepository.save(productB);
    }

    public void addProductA(Product product, SupplierProductBarcodeA supplierProductBarcodeA) {
        CatalogA productA = new CatalogA();
        productA.setDescription(product.getDescription());
        productA.setSKU(supplierProductBarcodeA.getPrimaryKey().getSKU());

        catalogARepository.save(productA);
    }

    public List<Catalog> getMasterCatalog(Set<String> skuSet) {

        skuSet.forEach(System.out::println);

        Map<String, String> catalogMap = new HashMap<>();
        List<Catalog> catalog = new ArrayList<>();

        skuSet.forEach(sku -> catalogMap.put(sku, "null"));

        for(Map.Entry<String, String> entry: catalogMap.entrySet()) {
            Optional<CatalogA> catlogA = catalogARepository.findById(entry.getKey());
            if(catlogA.isPresent()){
                entry.setValue(catlogA.get().getDescription());
                catalog.add(new Catalog().SKU(entry.getKey()).description(entry.getValue()).company(Company.COMPANY_A));
            }
            else {
                Optional<CatalogB> catlogB = catalogBRepository.findById(entry.getKey());
                catlogB.ifPresent(cataB -> entry.setValue(cataB.getDescription()));
                catalog.add(new Catalog().SKU(entry.getKey()).description(entry.getValue()).company(Company.COMPANY_B));
            }
        }

        return catalog;
    }

    public void deleteProductFromCatalog(String company, String sku) {
        switch(company) {
            case "COMPANY_A":
                catalogARepository.deleteById(sku);
                break;
            case "COMPANY_B":
                catalogBRepository.deleteById(sku);
                break;
        }
    }
}
