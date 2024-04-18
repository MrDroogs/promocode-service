package com.swifttech.promocodeservice.repository;

import com.swifttech.promocodeservice.entity.ServiceChargeEntity;
import com.swifttech.promocodeservice.enums.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ServiceChargeRepository extends JpaRepository<ServiceChargeEntity, UUID> {

    ServiceChargeEntity findByType(Type type);
}
