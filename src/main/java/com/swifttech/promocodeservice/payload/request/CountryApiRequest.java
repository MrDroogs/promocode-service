package com.swifttech.promocodeservice.payload.request;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CountryApiRequest {
    private List<UUID> countryIds;
}
