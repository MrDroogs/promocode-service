package com.swifttech.promocodeservice.payload.jsonB;

import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record CurrencyRecord(@NotEmpty(message = "Name is required") List<String> name) {
}
