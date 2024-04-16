package com.swifttech.promocodeservice.util;

import com.swifttech.promocodeservice.core.base.Codes;
import com.swifttech.promocodeservice.core.exception.RemitException;
import com.swifttech.promocodeservice.entity.PromoCodeEntity;
import com.swifttech.promocodeservice.repository.AmountRepository;
import com.swifttech.promocodeservice.repository.CountWiseRepository;
import com.swifttech.promocodeservice.repository.CustomerRepository;
import com.swifttech.promocodeservice.repository.PromoCodeRepository;
import com.swifttech.promocodeservice.service.impl.PromoCodeServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class DataValidation {
    private final PromoCodeRepository promoCodeRepository;
    private final CustomerRepository customerRepository;
    private final CountWiseRepository countWiseRepository;
    private final AmountRepository amountRepository;
    private final Codes codes;
    private static final Logger LOG = LoggerFactory.getLogger(PromoCodeServiceImpl.class);

    public boolean isPromoCodeExists(UUID id, PromoCodeEntity promoCodeEntity) {
        try {
            PromoCodeEntity promoCode = promoCodeRepository.findById(id).
                    orElseThrow(() -> new RemitException(codes.pick("PRM002")));

            return true;

        } catch (RemitException e) {
            return false;

        }
    }


}
