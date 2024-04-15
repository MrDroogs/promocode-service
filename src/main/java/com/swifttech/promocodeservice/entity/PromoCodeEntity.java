package com.swifttech.promocodeservice.entity;

import com.swifttech.promocodeservice.core.base.entity.BaseAuditEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Calendar;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "promo_code")
public class PromoCodeEntity extends BaseAuditEntity {
    @Column(nullable = false)
    private String promoCodeName;
    @Column(nullable = false)
    private String promoCodeDescription;
    @Column(nullable = false)
    private Boolean applicableForTransaction;
    private UUID recievingCountry;
    private UUID sendingCountry;
    @Column(nullable = false)
    private String currency;
    @Column(nullable = false)
    private Calendar startDate;
    @Column(nullable = false)
    private Calendar endDate;
    @Column(nullable = false)
    private int applicableDays;
    @Column(nullable = false)
    private Boolean specifiedTime;
    @Column(columnDefinition = "TIMESTAMP",nullable = false)
    private Calendar startTime;
    @Column(columnDefinition = "TIMESTAMP",nullable = false)
    private Calendar endTime;

}
