package com.swifttech.promocodeservice.entity;

import com.swifttech.promocodeservice.core.base.entity.BaseAuditEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "service_charge")
public class ServiceCharge extends BaseAuditEntity {
    private String type;
    private String value;
}
