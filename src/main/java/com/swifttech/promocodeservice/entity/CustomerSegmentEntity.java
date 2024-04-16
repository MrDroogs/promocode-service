package com.swifttech.promocodeservice.entity;

import com.swifttech.promocodeservice.core.base.entity.BaseAuditEntity;
import com.swifttech.promocodeservice.enums.Gender;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "customer_segment")
public class CustomerSegmentEntity extends BaseAuditEntity {
  private String kycStatus;
  private Gender gender;
  private List<String> Nationality;
  private String Age;
  private String visaType;
}