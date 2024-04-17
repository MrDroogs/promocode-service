package com.swifttech.promocodeservice.payload.response;

import com.swifttech.promocodeservice.enums.Status;

import java.io.Serializable;
import java.util.UUID;

public record CurrencyResponse(UUID id, String name, String code, Status status) implements Serializable {

}
