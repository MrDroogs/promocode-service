package com.swifttech.promocodeservice.service.impl;

import com.google.gson.Gson;
import com.swifttech.promocodeservice.core.base.Codes;
import com.swifttech.promocodeservice.core.exception.RemitException;
import com.swifttech.promocodeservice.core.model.ApiResponse;
import com.swifttech.promocodeservice.entity.PromoCodeEntity;
import com.swifttech.promocodeservice.enums.Status;
import com.swifttech.promocodeservice.mapper.PromoCodeMapper;
import com.swifttech.promocodeservice.payload.jsonB.CurrencyRecord;
import com.swifttech.promocodeservice.payload.request.PaginationRequest;
import com.swifttech.promocodeservice.payload.request.PromoCodeRequest;
import com.swifttech.promocodeservice.payload.response.PromoCodeList;
import com.swifttech.promocodeservice.repository.CustomerRepository;
import com.swifttech.promocodeservice.repository.PromoCodeRepository;
import com.swifttech.promocodeservice.service.PromoCodeService;
import com.swifttech.promocodeservice.util.DataValidation;
import com.swifttech.promocodeservice.util.InterCommunication;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

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
        log.info("COUNTRY REQUEST DATA {}", new Gson().toJson(countryIds));
        interCommunication.getCountry(countryIds);
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

    @Override
    public List<PromoCodeList> promoCodeList(PaginationRequest pagination) {
        Pageable pageable = PageRequest.of(pagination.pages(), pagination.size(),
                Sort.by(Objects.equals(pagination.sortDirection(), "asc") ? Sort.Direction.ASC : Sort.Direction.DESC,
                        pagination.sortBy() == null ? "createdAt" : pagination.sortBy()));
        Page<PromoCodeEntity> promoCodePage = promoCodeRepository.findAll(pageable);
        List<PromoCodeEntity> promoCodeList = promoCodePage.getContent();
        return promoCodeList.stream()
                .map(PromoCodeMapper.Instance::toPromoCodeList)
                .toList();
    }

    @Override
    public void updatePromoCode(UUID id, PromoCodeRequest promoCodeRequest) {
        try {
            PromoCodeEntity existingPromoCode = promoCodeRepository.findByPromoCodeName(promoCodeRequest.getPromoCodeName());
            if (existingPromoCode != null) {
                throw new RemitException(codes.pick("PRM001"));
            }


            List<UUID> countryIds = new ArrayList<>();
            countryIds.add(promoCodeRequest.getSendingCountry());
            countryIds.add(promoCodeRequest.getReceivingCountry());
            log.info("COUNTRY REQUEST DATA {}", new Gson().toJson(countryIds));
            interCommunication.getCountry(countryIds);

            ApiResponse currencyApiResponse = interCommunication.getCurrency(promoCodeRequest.getCurrency());
            if (!currencyApiResponse.isSuccess()) {
                throw new RemitException(codes.pick("CURRENCY_API_ERROR"));
            }

            PromoCodeEntity promoCode = PromoCodeMapper.Instance.toEntity(promoCodeRequest);
            promoCode.setReceivingCountry(promoCode.getReceivingCountry());
            promoCode.setSendingCountry(promoCode.getSendingCountry());
            promoCodeRepository.save(promoCode);

        } catch (RemitException e) {
            log.error("Error occurred while updating promo code: {}", e.getMessage());
            throw e; // Re-throwing the exception for handling at a higher level
        } catch (Exception e) {
            log.error("Unexpected error occurred while updating promo code", e);
            throw new RemitException(codes.pick("PRM004"));
        }
    }

    @Override
    public void deletePromoCode(UUID id) {
        Optional<PromoCodeEntity> promoCodeId = promoCodeRepository.findById(id);
        if (promoCodeId.isPresent()) {
            PromoCodeEntity promoCode = promoCodeId.get();
            promoCodeRepository.save(promoCode);
        }
    }


}











