package com.swifttech.promocodeservice.payload.response;


import com.swifttech.promocodeservice.enums.Status;

import java.io.Serializable;

import java.util.List;
import java.util.UUID;

public record CountryResponse(UUID id, String name, String iso2, String iso3, String teleCode, String baseCurrency,
                              String image, Status status, List<CurrencyResponse> supportedCurrency,
                              RegionResponse region) implements Serializable {






}