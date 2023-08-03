package com.shopmanagement.repository;

import com.shopmanagement.entity.DailyCostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface DailyCostRepository extends JpaRepository<DailyCostEntity,Long> {
}
