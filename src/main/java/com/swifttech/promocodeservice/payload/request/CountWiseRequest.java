package com.swifttech.promocodeservice.payload.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class CountWiseRequest {
    private String promoCodeType;
    private BigDecimal promoCodeValue;
    private int TotalApplicableNumber;
}
