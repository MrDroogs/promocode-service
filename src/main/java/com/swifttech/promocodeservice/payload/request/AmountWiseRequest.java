package com.swifttech.promocodeservice.payload.request;


import com.swifttech.promocodeservice.enums.AmountEnum;
import com.swifttech.promocodeservice.enums.Type;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
public class AmountWiseRequest {
    @Enumerated(EnumType.STRING)
    private AmountEnum amountEnum;
    private BigDecimal promoCodeValue;
    private Type type;
    private BigDecimal value;
    private String promoCodeType;
    private BigDecimal startRange;
    private BigDecimal endRange;
    private BigDecimal maxAmount;

}
