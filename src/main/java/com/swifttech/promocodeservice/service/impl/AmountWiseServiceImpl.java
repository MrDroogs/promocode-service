package com.swifttech.promocodeservice.service.impl;

import com.swifttech.promocodeservice.core.base.Codes;
import com.swifttech.promocodeservice.entity.AmountWiseEntity;
import com.swifttech.promocodeservice.enums.AmountEnum;
import com.swifttech.promocodeservice.payload.request.AmountWiseRequest;
import com.swifttech.promocodeservice.repository.AmountRepository;
import com.swifttech.promocodeservice.service.AmountWiseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AmountWiseServiceImpl implements AmountWiseService {
    private static final Logger LOG = LoggerFactory.getLogger(AmountWiseServiceImpl.class);
    private final AmountRepository amountRepository;
    private final Codes codes;
    @Override
    public void createAmountWise(AmountWiseRequest amountWiseRequest) {
        AmountWiseEntity amountWise = amountRepository.findByAmountEnum(amountWiseRequest.getAmountEnum());
        if (amountWise != null && amountWise.getAmountEnum() != null) { // Check if amountWise and its amountEnum are not null
            if (amountWiseRequest.getAmountEnum() == AmountEnum.FLAT) {
                amountWise.setPromoCodeType(amountWiseRequest.getPromoCodeType());
                amountWise.setPromoCodeValue(amountWiseRequest.getPromoCodeValue());
            } else if (amountWiseRequest.getAmountEnum() == AmountEnum.SLAB) {
                amountWise.setType(amountWiseRequest.getType());
                amountWise.setValue(amountWiseRequest.getValue());
                amountWise.setStartRange(amountWiseRequest.getStartRange());
                amountWise.setEndRange(amountWiseRequest.getEndRange());
                amountWise.setMaxAmount(amountWiseRequest.getMaxAmount());
            }
            amountRepository.save(amountWise);
        }
    }

}


