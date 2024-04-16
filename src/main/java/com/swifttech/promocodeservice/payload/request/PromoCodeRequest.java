package com.swifttech.promocodeservice.payload.request;


import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
public class PromoCodeRequest {
    private String promoCodeName;
    private String promoCodeDescription;
    private Boolean applicableForTransaction;
    private UUID receivingCountry;
    private UUID sendingCountry;
    private  UUID Currency;
    private Calendar startDate;
    private Calendar endDate;
    private UUID applicableDays;
    private Boolean specifiedTime;
    @Column(columnDefinition = "TIMESTAMP")
    private Calendar startTime;
    @Column(columnDefinition = "TIMESTAMP")
    private Calendar endTime;

}
