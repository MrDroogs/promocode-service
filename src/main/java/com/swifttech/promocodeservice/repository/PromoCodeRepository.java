package com.swifttech.promocodeservice.repository;

import com.swifttech.promocodeservice.entity.BasicSetupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PromoCodeRepository extends JpaRepository<BasicSetupEntity, UUID> {
    BasicSetupEntity findByPromoCodeName(String promoCodeName);
}
