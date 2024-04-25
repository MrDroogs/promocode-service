package com.swifttech.promocodeservice.payload.request;

import com.swifttech.promocodeservice.entity.*;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;
import java.util.List;
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
    private Boolean specificTime;
    @Column(columnDefinition = "TIMESTAMP")
    private Calendar startTime;
    @Column(columnDefinition = "TIMESTAMP")
    private Calendar endTime;
}
