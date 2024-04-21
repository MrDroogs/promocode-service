package com.swifttech.promocodeservice.entity;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.swifttech.promocodeservice.core.base.entity.BaseAuditEntity;
import jakarta.persistence.Entity;
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
@Entity
@Table(name = "time_frame")
public class TimeFrameEntity extends BaseAuditEntity {
    private Calendar startDate;
    private Calendar endDate;
    private UUID applicableDays;
    private Boolean specificTime;
    private Calendar startTime;
    private Calendar endTime;

}
