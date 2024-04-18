package com.swifttech.promocodeservice.payload.request;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;
import java.util.UUID;

@Getter
@Setter
@Builder
public class TimeFrameRequest {
    @Column(columnDefinition = "TIMESTAMP")
    private Calendar startDate;
    @Column(columnDefinition = "TIMESTAMP")
    private Calendar endDate;
    private UUID applicableDays;
    private Boolean specifiedTime;
    @Column(columnDefinition = "TIMESTAMP")
    private Calendar startTime;
    @Column(columnDefinition = "TIMESTAMP")
    private Calendar endTime;
}
