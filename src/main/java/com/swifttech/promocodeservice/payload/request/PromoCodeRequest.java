package com.swifttech.promocodeservice.payload.request;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PromoCodeRequest {
    @GeneratedValue
    private UUID id;
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
