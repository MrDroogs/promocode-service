package com.swifttech.promocodeservice.payload.response;

import com.swifttech.promocodeservice.enums.ApprovalStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PromoCodeList(String promoCodeName, BigDecimal totalBudget, BigDecimal RemainingBudget, LocalDateTime period,
                            ApprovalStatus status) {
}
