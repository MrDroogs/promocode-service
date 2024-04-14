package com.swifttech.promocodeservice.payload.request;

import jakarta.persistence.Column;
import lombok.*;

import java.util.Calendar;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PromoCodeSetupRequest {
    private String promoCodeName;
    private String promoCodeDescription;
    private Boolean applicableForTransaction;
    private UUID recievingCountry;
    private UUID sendingCountry;
    private String Currency;
    private Calendar startDate;
    private Calendar endDate;
    private int applicableDays;
    private Boolean specifiedTime;
    @Column(columnDefinition = "TIMESTAMP")
    private Calendar startTime;
    @Column(columnDefinition = "TIMESTAMP")
    private Calendar endTime;


}
