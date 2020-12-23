package com.coding.util;

import com.coding.dto.Catalog;
import com.coding.repository.model.*;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class CSVUtil {

    public static List<Suppliers> readSuppliers(InputStream in) {
        List<Suppliers> suppliersList = new BufferedReader(new InputStreamReader(in))
                .lines()
                .skip(1)
                .map(line -> {
                    String[] values = line.split(",");
                    Suppliers suppliers = new Suppliers(values[0], values[1]);
                    return suppliers;
                })
                .collect(Collectors.toList());

        return suppliersList;
    }

    public static List<SupplierProductBarcodeA> readProductsA(InputStream in) {
        List<SupplierProductBarcodeA> productsList = new BufferedReader(new InputStreamReader(in))
                .lines()
                .skip(1)
                .map(line -> {
                    String[] values = line.split(",");
                    SuppliersA suppliersA = new SuppliersA().supplierId(values[0]);
                    SupplierProductBarcodeA products = new SupplierProductBarcodeA(new BKey(values[1], values[0], values[2]), suppliersA);
                    return products;
                })
                .collect(Collectors.toList());

        return productsList;
    }

    public static List<SupplierProductBarcodeB> readProductsB(InputStream in) {
        List<SupplierProductBarcodeB> productsList = new BufferedReader(new InputStreamReader(in))
                .lines()
                .skip(1)
                .map(line -> {
                    String[] values = line.split(",");
                    SuppliersB suppliersB = new SuppliersB().supplierId(values[0]);
                    SupplierProductBarcodeB products = new SupplierProductBarcodeB(new BKey(values[1], values[0], values[2]), suppliersB);
                    return products;
                })
                .collect(Collectors.toList());

        return productsList;
    }


    public static InputStream getInputStream(String fileName) throws FileNotFoundException {
        ClassLoader classLoader = CSVUtil.class.getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        return new FileInputStream(file);
    }

    public static List<CatalogA> readCatalogA(InputStream in) {
        List<CatalogA> catalogList = new BufferedReader(new InputStreamReader(in))
                .lines()
                .skip(1)
                .map(line -> {
                    String[] values = line.split(",");
                    CatalogA catalogA = new CatalogA().SKU(values[0]).description(values[1]);
                    return catalogA;
                })
                .collect(Collectors.toList());

        return catalogList;
    }

    public static List<CatalogB> readCatalogB(InputStream inB) {
        List<CatalogB> catalogList = new BufferedReader(new InputStreamReader(inB))
                .lines()
                .skip(1)
                .map(line -> {
                    String[] values = line.split(",");
                    CatalogB catalogB = new CatalogB().SKU(values[0]).description(values[1]);
                    return catalogB;
                })
                .collect(Collectors.toList());

        return catalogList;
    }

    public static void writeOutputToCSV(List<Catalog> mergedCatalog) throws IOException {
        FileWriter csvWriter = new FileWriter(new File("output.csv"));
        csvWriter.append("SKU");
        csvWriter.append(",");
        csvWriter.append("Description");
        csvWriter.append(",");
        csvWriter.append("Company");
        csvWriter.append("\n");

        for (Catalog catalog : mergedCatalog) {
            csvWriter.append(String.join(",", catalog.getSKU(), catalog.getDescription(), catalog.getCompany().name()));
            csvWriter.append("\n");
        }
        csvWriter.flush();
        csvWriter.close();
    }
}
