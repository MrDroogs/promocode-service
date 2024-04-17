package com.swifttech.promocodeservice.service.impl;

import com.google.gson.Gson;
import com.swifttech.promocodeservice.core.base.Codes;
import com.swifttech.promocodeservice.core.exception.RemitException;
import com.swifttech.promocodeservice.core.model.ApiResponse;
import com.swifttech.promocodeservice.entity.PromoCodeEntity;
import com.swifttech.promocodeservice.mapper.PromoCodeMapper;
import com.swifttech.promocodeservice.payload.jsonB.CountryRecord;
import com.swifttech.promocodeservice.payload.jsonB.CurrencyRecord;
import com.swifttech.promocodeservice.payload.request.CountryApiRequest;
import com.swifttech.promocodeservice.payload.request.PromoCodeRequest;
import com.swifttech.promocodeservice.payload.response.CountryResponse;
import com.swifttech.promocodeservice.repository.CustomerRepository;
import com.swifttech.promocodeservice.repository.PromoCodeRepository;
import com.swifttech.promocodeservice.service.PromoCodeService;
import com.swifttech.promocodeservice.util.DataValidation;
import com.swifttech.promocodeservice.util.InterCommunication;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PromoCodeServiceImpl implements PromoCodeService {
    private static final Logger LOG = LoggerFactory.getLogger(PromoCodeServiceImpl.class);
    private final PromoCodeRepository promoCodeRepository;
    private final CustomerRepository customerRepository;
    private final Codes codes;
    private final DataValidation dataValidation;
    private final InterCommunication interCommunication;


    @Override
    public void createPromoCode(PromoCodeRequest promoCodeRequest) {
        PromoCodeEntity promoCode = promoCodeRepository.findByPromoCodeName(promoCodeRequest.getPromoCodeName());
        if (promoCode != null) {
            throw new RemitException(codes.pick("PRM001"));
        }
        List<UUID> countryIds = new ArrayList<>();
        countryIds.add(promoCodeRequest.getSendingCountry());
        countryIds.add(promoCodeRequest.getReceivingCountry());
        CountryApiRequest countryApiRequest = CountryApiRequest.builder()
                .countryIds(countryIds)
                .build();
        log.info("COUNTRY REQUEST DATA {}", new Gson().toJson(countryApiRequest));
        interCommunication.getCountry(countryApiRequest);
        ApiResponse currencyResponse = interCommunication.getCurrency(promoCodeRequest.getCurrency());
        if (currencyResponse.isSuccess()) {
            Object currencyResponseData = currencyResponse.getData();
            if (currencyResponseData instanceof ArrayList) { // Corrected variable name
                ArrayList<LinkedHashMap<String, Object>> currencyList =
                        (ArrayList<LinkedHashMap<String, Object>>) currencyResponseData; // Corrected variable name
                List<String> currencyNames = currencyList.stream()
                        .parallel()
                        .map(currency -> (String) currency.get("name")) // Assuming "name" is always a string
                        .toList();


                CurrencyRecord currencyRecord = new CurrencyRecord(currencyNames);

            }
        }
        promoCode = PromoCodeMapper.Instance.toEntity(promoCodeRequest);
        promoCodeRepository.save(promoCode);
    }
}



