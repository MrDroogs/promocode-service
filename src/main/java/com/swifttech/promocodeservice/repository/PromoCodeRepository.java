package com.swifttech.promocodeservice.repository;

import com.swifttech.promocodeservice.entity.PromoCodeEntity;
import com.swifttech.promocodeservice.payload.request.PromoCodeRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PromoCodeRepository extends JpaRepository<PromoCodeEntity, UUID> {




}
