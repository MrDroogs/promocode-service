package com.swifttech.promocodeservice.entity;

import com.swifttech.promocodeservice.core.base.entity.BaseAuditEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "budget_usage")
public class BudgetUsageEntity extends BaseAuditEntity {
    private BigDecimal minTransactionAmount;
    private BigDecimal maxPromoCodeValuePerTransaction;
    private  int totalPromoCountForNUsers;
    private BigDecimal totalPromoValuePerUser;
    private int totalPromoCountPerUser;
    private BigDecimal totalPromoBudget;

}
