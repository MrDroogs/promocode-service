package com.swifttech.promocodeservice.service.impl;

import com.swifttech.promocodeservice.core.base.Codes;
import com.swifttech.promocodeservice.core.exception.RemitException;
import com.swifttech.promocodeservice.entity.PromoCodeEntity;
import com.swifttech.promocodeservice.mapper.PromoCodeMapper;
import com.swifttech.promocodeservice.payload.request.PaginationRequest;
import com.swifttech.promocodeservice.payload.request.PromoCodeRequest;
import com.swifttech.promocodeservice.payload.response.PromoCodeList;
import com.swifttech.promocodeservice.repository.CustomerRepository;
import com.swifttech.promocodeservice.repository.PromoCodeRepository;
import com.swifttech.promocodeservice.service.PromoCodeService;
import com.swifttech.promocodeservice.util.DataValidation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class PromoCodeServiceImpl implements PromoCodeService {
    private static final Logger LOG = LoggerFactory.getLogger(PromoCodeServiceImpl.class);
    private final PromoCodeRepository promoCodeRepository;
    private final CustomerRepository customerRepository;
    private final Codes codes;
    private final DataValidation dataValidation;



    @Override
    public void createPromoCode(PromoCodeRequest promoCodeRequest) throws RemitException {


        if (dataValidation.isPromoCodeExists(promoCodeRequest.getId(), promoCodeRequest)) {
            throw new RemitException(codes.pick("PRM002") );
        }

        PromoCodeEntity promoCode = PromoCodeMapper.Instance.toEntity(promoCodeRequest);
        promoCode = PromoCodeEntity.builder()
                .promoCodeName(promoCodeRequest.getPromoCodeName())
                .promoCodeDescription(promoCodeRequest.getPromoCodeDescription())
                .applicableForTransaction(promoCodeRequest.getApplicableForTransaction())
                .build();

        if (!promoCodeRequest.getApplicableForTransaction()) {
            promoCode = promoCode.builder()
                    .applicableDays(promoCodeRequest.getApplicableDays())
                    .startDate(promoCodeRequest.getStartDate())
                    .endDate(promoCodeRequest.getEndDate())
                    .startTime(promoCodeRequest.getStartTime())
                    .endTime(promoCodeRequest.getEndTime())
                    .build();

        if (promoCodeRequest.getSpecifiedTime()) {
            promoCode=promoCode.builder()
                    .startTime(promoCodeRequest.getStartTime())
                    .endTime(promoCodeRequest.getEndTime())
                    .build();
        }

        } else {
            promoCode = promoCode.builder()
                    .recievingCountry(promoCodeRequest.getRecievingCountry())
                    .sendingCountry(promoCodeRequest.getSendingCountry())
                    .currency(promoCodeRequest.getCurrency())
                    .startDate(promoCodeRequest.getStartDate())
                    .endDate(promoCodeRequest.getEndDate())
                    .applicableDays(promoCodeRequest.getApplicableDays())
                    .specifiedTime(promoCodeRequest.getSpecifiedTime())
                    .startTime(promoCodeRequest.getStartTime())
                    .endTime(promoCodeRequest.getEndTime())
                    .build();
        }
        promoCodeRepository.save(promoCode);
    }



    @Override
    public void updatePromoCode(UUID id, PromoCodeRequest promoCodeRequest) throws RemitException {
        if (!dataValidation.isPromoCodeExists(id, promoCodeRequest)) {
            throw new RemitException(codes.pick("PRM002"));
        }
        PromoCodeEntity existingPromoCode = promoCodeRepository.findById(id)
                .orElseThrow(() -> new RemitException(codes.pick( "PRM001 ")));
        PromoCodeEntity promoCode = PromoCodeMapper.Instance.toEntity(promoCodeRequest);
        promoCode.setId(existingPromoCode.getId());
        promoCode.setPromoCodeName(existingPromoCode.getPromoCodeName());
        promoCode.setPromoCodeDescription(existingPromoCode.getPromoCodeDescription());
        promoCode.setStartDate(existingPromoCode.getStartDate());
        promoCode.setEndDate(existingPromoCode.getEndDate());
//        promoCode.setSendingCountry(existingPromoCode.getSendingCountry());
//        promoCode.setRecievingCountry(existingPromoCode.getRecievingCountry());
        promoCode.setSpecifiedTime(existingPromoCode.getSpecifiedTime());

        promoCode.setStartTime(existingPromoCode.getStartTime());
        promoCode.setEndTime(existingPromoCode.getEndTime());
        promoCodeRepository.save(promoCode);
    }
    @Override
    public List<PromoCodeList> promoCodeList(PromoCodeRequest promoCodeRequest) {
       List<PromoCodeEntity> promoCodeEntities = promoCodeRepository.findAll();
       return promoCodeEntities.stream()
               .map(PromoCodeMapper.Instance::toList)
               .toList();

    }







}
