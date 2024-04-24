package com.swifttech.promocodeservice.payload.request;

import com.swifttech.promocodeservice.enums.Type;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Builder
public class ServiceChargeRequest {
    private Type type;
    private BigDecimal value;
}
