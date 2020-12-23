package com.coding.repository;

import com.coding.repository.model.SuppliersB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Repository
@EnableTransactionManagement
public interface SupplierBRepository extends JpaRepository<SuppliersB, String> {
}
