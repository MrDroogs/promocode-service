package com.swifttech.promocodeservice.entity;

import com.swifttech.promocodeservice.core.base.entity.BaseAuditEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "promo_Code")
public class PromoCodeEntity extends BaseAuditEntity {

    private String promoCodeName;
    private String promoCodeDescription;
    private Boolean applicableForTransaction;
    private UUID receivingCountry;
    private UUID sendingCountry;
    private UUID receivingCurrency;
    @OneToMany(cascade = CascadeType.MERGE)
    private List<AmountWiseEntity> amountWise;
    @OneToOne(cascade = CascadeType.MERGE)
    private ServiceChargeEntity serviceCharge;
    @OneToOne(cascade = CascadeType.MERGE)
    private TimeFrameEntity timeFrame;
    @OneToOne(cascade = CascadeType.MERGE)
    private CountWiseEntity countWise;
    @OneToOne(cascade = CascadeType.MERGE)
    private  CustomerSegmentEntity customerSegment;
}
