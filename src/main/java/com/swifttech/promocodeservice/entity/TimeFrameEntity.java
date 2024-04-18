package com.swifttech.promocodeservice.entity;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Table(name = "time_frame")
public class TimeFrameEntity {
    private Calendar startDate;
    private Calendar endDate;
    private UUID applicableDays;
    private Boolean specifiedTime;
    private Calendar startTime;
    private Calendar endTime;
    private List<UUID> currency;
}
