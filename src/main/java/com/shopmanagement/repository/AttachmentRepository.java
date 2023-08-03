package com.shopmanagement.repository;

import com.shopmanagement.entity.AttachmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface AttachmentRepository extends JpaRepository<AttachmentEntity, Long> {
}
