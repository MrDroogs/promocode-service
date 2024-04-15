package com.swifttech.promocodeservice.entity;

import com.swifttech.promocodeservice.core.base.entity.BaseAuditEntity;
import com.swifttech.promocodeservice.enums.Gender;
import com.swifttech.promocodeservice.enums.KycStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "customer")
public class CustomerSegmentEntity extends BaseAuditEntity {
  @Enumerated(EnumType.STRING)
  private KycStatus kycStatus;
  @Enumerated(EnumType.STRING)
  private Gender gender;
  private String Nationality;
  private int Age;
  private String visaType;
}
