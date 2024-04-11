package com.swifttech.promocodeservice.payload.request;

import java.io.Serializable;
import java.util.UUID;

public record PromoCodeRequest(UUID id,
                               String promoCodeName,
                               String promoCodeDescription,
                               Boolean applicableForTransaction,
                               UUID recievingCountry,
                               UUID sendingCountry,
                               int Currency) implements Serializable {
}
