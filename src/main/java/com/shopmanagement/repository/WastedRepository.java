package com.shopmanagement.repository;

import com.shopmanagement.entity.WastedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface WastedRepository extends JpaRepository<WastedEntity,Long> {
}
