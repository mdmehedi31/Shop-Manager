package com.shopmanagement.repository;


import com.shopmanagement.entity.AddCustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface AddCustomerRepository extends JpaRepository<AddCustomerEntity, Long> {
}
