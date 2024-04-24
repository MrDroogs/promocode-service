package com.swifttech.promocodeservice.payload.request;

import com.swifttech.promocodeservice.entity.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Builder
public class PromoCodeRequest {
    private String promoCodeName;
    private String promoCodeDescription;
    private Boolean applicableForTransaction;
    private UUID receivingCountry;
    private UUID sendingCountry;
    private List<UUID> Currency;
    @OneToMany(cascade = CascadeType.MERGE)
    private List<AmountWiseEntity> amountWise;
    @OneToOne(cascade = CascadeType.MERGE)
    private ServiceChargeEntity serviceCharge;
    @OneToOne(cascade = CascadeType.MERGE)
    private TimeFrameEntity timeFrame;
    @OneToOne(cascade = CascadeType.MERGE)
    private CountWiseEntity countWise;
    @OneToOne(cascade = CascadeType.MERGE)
    private CustomerSegmentEntity customerSegment;
}
