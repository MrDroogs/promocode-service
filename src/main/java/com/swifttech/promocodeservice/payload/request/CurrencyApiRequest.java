package com.swifttech.promocodeservice.payload.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class CurrencyApiRequest {
   private UUID currencyId;
}
