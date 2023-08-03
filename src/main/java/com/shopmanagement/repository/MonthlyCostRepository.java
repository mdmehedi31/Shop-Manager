package com.shopmanagement.repository;

import com.shopmanagement.entity.MonthlyCostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface MonthlyCostRepository extends JpaRepository<MonthlyCostEntity, Long> {
}
