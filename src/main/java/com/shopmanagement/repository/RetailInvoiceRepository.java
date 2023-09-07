package com.shopmanagement.repository;


import com.shopmanagement.entity.RetailInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface RetailInvoiceRepository extends JpaRepository<RetailInvoice,Long> {
}
