package com.swifttech.promocodeservice.payload.request;

import com.swifttech.promocodeservice.enums.ApprovalStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record FiterRequest(ApprovalStatus status, String PromoCode, BigDecimal budget, BigDecimal remainingBudget,
                           LocalDateTime period) {
}
