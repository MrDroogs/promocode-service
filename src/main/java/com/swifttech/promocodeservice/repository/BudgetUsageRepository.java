package com.swifttech.promocodeservice.repository;

import com.swifttech.promocodeservice.entity.BudgetUsageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BudgetUsageRepository extends JpaRepository<BudgetUsageEntity, UUID> {
}
