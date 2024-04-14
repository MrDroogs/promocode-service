package com.swifttech.promocodeservice.payload.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter

public class BudgetUsageRequest{
    BigDecimal minTransactionAmount;
    private BigDecimal maxPromoCodeValuePerTransaction;
    private  int totalPromoCountForNUsers;
    private BigDecimal totalPromoValuePerUser;
    private int totalPromoCountPerUser;
    private BigDecimal totalPromoBudget;
}
