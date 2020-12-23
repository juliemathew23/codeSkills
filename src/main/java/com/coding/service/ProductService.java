package com.coding.service;

import com.coding.dto.Product;
import com.coding.repository.ProductRepositoryA;
import com.coding.repository.ProductRepositoryB;
import com.coding.repository.model.BKey;
import com.coding.repository.model.SupplierProductBarcodeA;
import com.coding.repository.model.SupplierProductBarcodeB;
import com.coding.util.CSVUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;


@Service
public class ProductService {

    private final ProductRepositoryA productRepositoryA;

    private final ProductRepositoryB productRepositoryB;

    @Autowired
    public ProductService(ProductRepositoryA productRepositoryA, ProductRepositoryB productRepositoryB) {
        this.productRepositoryA = productRepositoryA;
        this.productRepositoryB = productRepositoryB;
    }

   @Transactional
    public void saveProduct() throws FileNotFoundException {
        InputStream in = CSVUtil.getInputStream("barcodesA.csv");
        List<SupplierProductBarcodeA> productsA = CSVUtil.readProductsA(in);
        productsA.forEach(product -> {
            productRepositoryA.save(product);
        });

        InputStream inB = CSVUtil.getInputStream("barcodesB.csv");
        List<SupplierProductBarcodeB> productsB = CSVUtil.readProductsB(inB);
        productsB.forEach(product -> {
            productRepositoryB.save(product);
        });
    }

    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        List<SupplierProductBarcodeA> productsA = productRepositoryA.findAll();
        List<SupplierProductBarcodeB> productsB =productRepositoryB.findAll();

        productsA.forEach(productA -> {
            products.add(new Product().barCode(productA.getPrimaryKey().getBarcode())
                    .SKU(productA.getPrimaryKey().getSKU()).supplierId(productA.getSuppliersA().getSupplierId()));
        });

        productsB.forEach(productB -> {
            products.add(new Product().barCode(productB.getPrimaryKey().getBarcode())
                    .SKU(productB.getPrimaryKey().getSKU()).supplierId(productB.getSuppliersB().getSupplierId()));
        });

        return products;
    }


    @Transactional
    public SupplierProductBarcodeB addProductB(Product product) {
        SupplierProductBarcodeB productB = new SupplierProductBarcodeB();
        BKey bKey = new BKey();
        bKey.setSupplierId(product.getSupplierId());
        bKey.setBarcode(product.getBarCode());
        bKey.setSKU(product.getSKU());
        productB.setPrimaryKey(bKey);

        SupplierProductBarcodeB productBarcodeB = productRepositoryB.save(productB);

        return productBarcodeB;
    }

    @Transactional
    public SupplierProductBarcodeA addProductA(Product product) {
        SupplierProductBarcodeA productA = new SupplierProductBarcodeA();
        BKey bKey = new BKey();
        bKey.setSupplierId(product.getSupplierId());
        bKey.setBarcode(product.getBarCode());
        bKey.setSKU(product.getSKU());
        productA.setPrimaryKey(bKey);

        SupplierProductBarcodeA productBarcodeA = productRepositoryA.save(productA);

        return productBarcodeA;
    }

    public Set<String> getMasterProductList() {
        Map<String, String>  productMap = new HashMap<>();
        Set<String> skuSet = new HashSet<>();

        List<SupplierProductBarcodeA> productsA = productRepositoryA.findAll();
        productsA.forEach(product -> productMap.put(product.getPrimaryKey().getBarcode(), product.getPrimaryKey().getSKU()));

        List<SupplierProductBarcodeB> productsB = productRepositoryB.findAll();
        productsB.forEach(product -> productMap.put(product.getPrimaryKey().getBarcode(), product.getPrimaryKey().getSKU()));

        for(Map.Entry<String, String> entry: productMap.entrySet()) {
            skuSet.add(entry.getValue());
        }

        return skuSet;
    }
}
