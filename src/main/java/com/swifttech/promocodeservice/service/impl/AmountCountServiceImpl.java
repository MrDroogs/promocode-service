package com.swifttech.promocodeservice.service.impl;

import com.swifttech.promocodeservice.core.base.Codes;
import com.swifttech.promocodeservice.entity.AmountWiseEntity;
import com.swifttech.promocodeservice.entity.CountWiseEntity;
import com.swifttech.promocodeservice.enums.AmountEnum;
import com.swifttech.promocodeservice.mapper.CountWiseMapper;
import com.swifttech.promocodeservice.payload.request.AmountWiseRequest;
import com.swifttech.promocodeservice.payload.request.CountWiseRequest;
import com.swifttech.promocodeservice.repository.AmountRepository;
import com.swifttech.promocodeservice.repository.CountWiseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AmountCountServiceImpl implements com.swifttech.promocodeservice.service.AmountCountServiceImpl {
    private static final Logger LOG = LoggerFactory.getLogger(AmountCountServiceImpl.class);
    private final AmountRepository amountRepository;
    private final CountWiseRepository countWiseRepository;
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

    @Override
    public void createCountWise(CountWiseRequest countWiseRequest) {
        CountWiseEntity countWise = countWiseRepository.findByPromoCodeType(countWiseRequest.getPromoCodeType());
        CountWiseMapper.Instance.toEntity(countWiseRequest);
        countWiseRepository.save(countWise);

    }

}


