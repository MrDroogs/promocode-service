package com.swifttech.promocodeservice.repository;

import com.swifttech.promocodeservice.entity.CustomerSegmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerSegmentEntity, UUID> {
}
