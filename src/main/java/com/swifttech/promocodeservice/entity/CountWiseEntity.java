package com.swifttech.promocodeservice.entity;

import com.swifttech.promocodeservice.core.base.entity.BaseAuditEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "count_wise")
public class CountWiseEntity extends BaseAuditEntity {
    private String promoCodeType;
    private BigDecimal promoCodeValue;
    private int totalApplicableNumber;
}
