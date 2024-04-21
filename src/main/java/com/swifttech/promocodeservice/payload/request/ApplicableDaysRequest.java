package com.swifttech.promocodeservice.payload.request;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApplicableDaysRequest {
    private List<UUID> applicableDays;
}
