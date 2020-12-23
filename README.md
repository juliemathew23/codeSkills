# Coding Skills Challenge

### The below describes a problem statement, make sure to read all the instructions in this readme before you start.

### Business Requirement:

- Company A have acquired Company B, A and B sell some common products, sourced from suppliers (Sometimes the same supplier, sometimes a different one). 
- The business wants to consolidate the product catalog into one superset (merged catalog). 

### There are possibilities like:

- Company A and B could have conflicting product codes (SKUs).
- Product codes might be same, but they are different products.
- Product codes are different, but they are same product.
- You should not be duplicating product records in merged catalog.
- Product on merged catalog must have information about the company it belongs to originally.  

The business provided the following information that may help in identifying a matching product:
- Products have associated suppliers, each supplier provides 1 or many barcodes for a product, 
- A product may have many suppliers,
- If any supplier barcode matches for one product of company A with Company B then we can consider that those products as the same.


So, you have following entities to play with:

<img src="./entity_diagram.png" width="800px" height="auto">



You need to produce code in your preferred language which can demonstrate following:

### Initial load
- Mega merge: All products from both companies should get merge into a common catalog

### BAU mode
- A new product added in Catalog A
- An existing product removed from Catalog A
- An existing product in Catalog B got new supplier with set of barcodes
 

### Sample Data 
Please refer input folder for following CSVs:
1. [catalogA.csv](input/catalogA.csv) - Products for Company A
1. [catalogB.csv](input/catalogB.csv) - Products for Company B
1. [suppliersA.csv](input/suppliersA.csv) - List of Suppliers for Company A
1. [suppliersB.csv](input/suppliersB.csv) - List of Suppliers for Company B
1. [barcodesA.csv](input/barcodesA.csv) - Product barcodes provided by supplier for company A
1. [barcodesB.csv](input/barcodesB.csv) - Product barcodes provided by supplier for company B
1. [result_output.csv](output/result_output.csv) - The correct results based on the above sample data


### Deliverables.
- com.coding.Application should be able to accept above data as csv files from input folder and must produce a merged catalog as a csv file in output folder.
- Proving your code works via unit testing is highly encouraged.
- Spend as little or as much time as you like ⌚
- The code you produce can be in any language ⭐
- The output of the efforts ❗ must be committed back into a Public Repo in Github and the URL shared back for review. 
- Document instructions on how to install and run your solution in the README.


### Instructions
Spring boot version: 2.1.2 Database: H2 database

Instructions
Populate Suppliers from csv and saving it in its table http://localhost:8090/suppliers/readFromCSV (GET)

After populating suppliers, to view the details http://localhost:8090/suppliers/getSupplierDetails (GET)

Populate Products from csv and saving it in its table http://localhost:8090/products/readFromCSV (GET)

After populating products, to view the details http://localhost:8090/products/getProductDetails (GET)

Populate Catalog from csv and saving it in its table http://localhost:8090/catalog/readFromCSV (GET)

After populating catalog, to view the details http://localhost:8090/catalog/getCatalogService (GET)

To get the merged list of catalog http://localhost:8090/products/getMergedProductList (GET)

Add a new product http://localhost:8090/products/newProduct (POST)
RequestBody: Product

Add a new supplier with new barcodes for existing product (POST) http://localhost:8090/products/newSupplier supplierName(), company(COMPANY_A or COMPANY_B), sku(exising sku), int numOfProducts (hard coded as 2)

To delete product from catalog http://localhost:8090/catalog/deleteProduct (DELETE)
Request param: company(COMPANY_A or COMPANY_B), SKU

Yet to do: test cases

