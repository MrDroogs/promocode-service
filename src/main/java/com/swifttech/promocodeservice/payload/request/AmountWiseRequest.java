package com.swifttech.promocodeservice.payload.request;

import com.swifttech.promocodeservice.enums.AmountEnum;

import java.math.BigDecimal;

public record AmountWiseRequest(AmountEnum amountEnum, BigDecimal promoCodeValue,String promoCodeType,BigDecimal startRange,BigDecimal endRange,BigDecimal maxAmount) {
}
