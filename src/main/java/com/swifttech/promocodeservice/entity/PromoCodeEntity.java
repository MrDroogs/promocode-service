package com.swifttech.promocodeservice.entity;

import com.swifttech.promocodeservice.core.base.entity.BaseAuditEntity;
import com.swifttech.promocodeservice.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "promo_code")
public class PromoCodeEntity extends BaseAuditEntity {

    private String promoCodeName;
    private String promoCodeDescription;
    private Boolean applicableForTransaction;
    private UUID receivingCountry;
    private UUID sendingCountry;
    private UUID receivingCurrency;
    @OneToMany
    private List<AmountWiseEntity> amountWise;
    @OneToOne
    private CountWiseEntity countWise;
    @OneToOne
    private ServiceChargeEntity serviceCharge;
    @OneToOne
    private TimeFrameEntity timeFrame;
    @OneToOne
    private CustomerSegmentEntity customerSegment;


}
