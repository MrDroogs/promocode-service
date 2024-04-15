package com.swifttech.promocodeservice.entity;

import com.swifttech.promocodeservice.core.base.entity.BaseAuditEntity;
import com.swifttech.promocodeservice.enums.AmountEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "amount_wise")
public class AmountWiseEntity extends BaseAuditEntity {
    @Enumerated(EnumType.STRING)
    private AmountEnum amountEnum;
    private BigDecimal promoCodeValue;
    private String promoCodeType;
    private BigDecimal startRange;
    private BigDecimal endRange;
    private BigDecimal maxAmount;
}