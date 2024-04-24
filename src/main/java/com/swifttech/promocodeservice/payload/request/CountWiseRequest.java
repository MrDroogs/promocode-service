package com.swifttech.promocodeservice.payload.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Builder
public class CountWiseRequest {
    private String promoCodeType;
    private BigDecimal promoCodeValue;
    private int totalApplicableNumber;
}
