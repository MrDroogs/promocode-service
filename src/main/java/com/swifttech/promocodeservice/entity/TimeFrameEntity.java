package com.swifttech.promocodeservice.entity;

import com.swifttech.promocodeservice.core.base.entity.BaseAuditEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Calendar;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "time_frame")
public class TimeFrameEntity  extends BaseAuditEntity {
    private Calendar startDate;
    private Calendar endDate;
    private int applicableDays;
    private Boolean specifiedTime;
    private Calendar startTime;
    private Calendar endTime;
}
