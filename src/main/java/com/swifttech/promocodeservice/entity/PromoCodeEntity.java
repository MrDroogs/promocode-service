package com.swifttech.promocodeservice.entity;

import com.swifttech.promocodeservice.core.base.entity.BaseAuditEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "promo_Code")
public class PromoCodeEntity extends BaseAuditEntity {
    private BasicSetupEntity basicSetup;
    private AmountWiseEntity amountWiseEntity;
    private ServiceChargeEntity serviceChargeEntity;
    private TimeFrameEntity timeFrameEntity;
    private  CustomerSegmentEntity customerSegmentEntity;
}
