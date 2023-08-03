package com.shopmanagement.repository;

import com.shopmanagement.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;





public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {

    CategoryEntity findByCategoryName(String name);

    CategoryEntity findIdByCategoryName(String name);

    String findByCatId(Long catId);

}
