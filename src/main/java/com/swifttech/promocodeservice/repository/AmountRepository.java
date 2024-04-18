package com.swifttech.promocodeservice.repository;

import com.swifttech.promocodeservice.entity.AmountWiseEntity;
import com.swifttech.promocodeservice.enums.AmountEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AmountRepository extends JpaRepository<AmountWiseEntity, UUID> {
    AmountWiseEntity findByAmountEnum(AmountEnum amountEnum);
}
