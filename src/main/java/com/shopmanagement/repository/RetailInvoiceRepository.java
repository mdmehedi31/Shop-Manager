package com.shopmanagement.repository;


import com.shopmanagement.entity.RetailInvoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RetailInvoiceRepository extends JpaRepository<RetailInvoice,Long> {
    RetailInvoice findByInvoiceNo(String invoiceNo);
}
