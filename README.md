# codeSkills

Spring boot version: 2.1.2
Database: H2 database


### Instructions
- Populate Suppliers from csv and saving it in its table
http://localhost:8090/suppliers/readFromCSV (GET)

- After populating suppliers, to view the details
http://localhost:8090/suppliers/getSupplierDetails (GET)

- Populate Products from csv and saving it in its table
http://localhost:8090/products/readFromCSV  (GET)

- After populating products, to view the details
http://localhost:8090/products/getProductDetails (GET)

- Populate Catalog from csv and saving it in its table
http://localhost:8090/catalog/readFromCSV  (GET)  

- After populating catalog, to view the details
http://localhost:8090/catalog/getCatalogService (GET)

- To get the merged list of catalog
http://localhost:8090/products/getMergedProductList (GET)

- Add a new product
http://localhost:8090/products/newProduct (POST)  
RequestBody: Product

- Add a new supplier with new barcodes for existing product (POST)
http://localhost:8090/products/newSupplier
supplierName(), company(COMPANY_A or COMPANY_B), sku(exising sku), int numOfProducts (hard coded as 2)

- To delete product from catalog
http://localhost:8090/catalog/deleteProduct (DELETE)   
Request param: company(COMPANY_A or COMPANY_B), SKU



Yet to do: test cases

