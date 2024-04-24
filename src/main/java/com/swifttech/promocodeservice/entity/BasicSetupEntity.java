package com.swifttech.promocodeservice.entity;

import com.swifttech.promocodeservice.core.base.entity.BaseAuditEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "promo_code")
public class BasicSetupEntity extends BaseAuditEntity {

    private String promoCodeName;
    private String promoCodeDescription;
    private Boolean applicableForTransaction;
    private UUID receivingCountry;
    private UUID sendingCountry;
    private UUID receivingCurrency;



}