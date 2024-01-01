package com.shopmanagement.repository;

import com.shopmanagement.entity.RetailInvoiceProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RetailInvoiceProductRepository extends JpaRepository<RetailInvoiceProduct,Long> {
    List<RetailInvoiceProduct> findAllByRvId(Long rvId);
}
