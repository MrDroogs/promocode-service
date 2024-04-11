package com.swifttech.promocodeservice.service.impl;

import com.swifttech.promocodeservice.core.base.Codes;
import com.swifttech.promocodeservice.payload.request.PromoCodeRequest;
import com.swifttech.promocodeservice.repository.BudgetUsageRepository;
import com.swifttech.promocodeservice.repository.CustomerRepository;
import com.swifttech.promocodeservice.repository.PromoCodeRepository;
import com.swifttech.promocodeservice.repository.TimeFrameRepository;
import com.swifttech.promocodeservice.service.PromoCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PromoCodeServiceImpl implements PromoCodeService {
    private final PromoCodeRepository promoCodeRepository;
    private final BudgetUsageRepository budgetUsageRepository;
    private final CustomerRepository customerRepository;
    private final TimeFrameRepository timeFrameRepository;
    private final Codes codes;


    @Override
    public void createPromoCode(PromoCodeRequest promoCodeRequest) {

    }
}
