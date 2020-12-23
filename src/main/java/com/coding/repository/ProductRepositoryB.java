package com.coding.repository;

import com.coding.repository.model.SupplierProductBarcodeB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Repository
@EnableTransactionManagement
public interface ProductRepositoryB extends JpaRepository<SupplierProductBarcodeB, String> {
}
