package com.swifttech.promocodeservice.repository;

import com.swifttech.promocodeservice.entity.TimeFrameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface TimeFrameRepository extends JpaRepository<TimeFrameEntity, UUID>, JpaSpecificationExecutor<TimeFrameEntity> {
}
