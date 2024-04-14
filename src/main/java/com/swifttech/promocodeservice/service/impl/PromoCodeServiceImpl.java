package com.swifttech.promocodeservice.service.impl;

import com.swifttech.promocodeservice.core.base.Codes;
import com.swifttech.promocodeservice.core.exception.RemitException;
import com.swifttech.promocodeservice.entity.PromoCodeEntity;
import com.swifttech.promocodeservice.mapper.PromoCodeMapper;
import com.swifttech.promocodeservice.payload.request.PaginationRequest;
import com.swifttech.promocodeservice.payload.request.PromoCodeRequest;
import com.swifttech.promocodeservice.payload.response.PromoCodeList;
import com.swifttech.promocodeservice.repository.BudgetUsageRepository;
import com.swifttech.promocodeservice.repository.CustomerRepository;
import com.swifttech.promocodeservice.repository.PromoCodeRepository;
import com.swifttech.promocodeservice.service.PromoCodeService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor

public class PromoCodeServiceImpl implements PromoCodeService {
    private static final Logger LOG = LoggerFactory.getLogger(PromoCodeServiceImpl.class);
    private final PromoCodeRepository promoCodeRepository;
    private final BudgetUsageRepository budgetUsageRepository;
    private final CustomerRepository customerRepository;
    private final Codes codes;



    @Override
    public void createPromoCode(PromoCodeRequest promoCodeRequest) throws RemitException {
        Optional<PromoCodeEntity> promoCodeEntity = promoCodeRepository.findById(promoCodeRequest.getId());
        promoCodeEntity = Optional.ofNullable(PromoCodeMapper.Instance.toEntity(promoCodeRequest));
        PromoCodeEntity promoCode = PromoCodeEntity.builder()
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
    public List<PromoCodeList> promoCodeList(PaginationRequest pagination) {
        Pageable pageable = PageRequest.of(pagination.pages(), pagination.size(),
                Sort.by(Objects.equals(pagination.sortDirection(), "asc") ? Sort.Direction.ASC : Sort.Direction.DESC,
                        pagination.sortBy() == null ? "createdAt" : pagination.sortBy()));
//        Page<PromoCodeEntity> promoPage = promoCodeRepository.findAll(pageable);
//        List<PromoCodeList> promoCodeLists = promoPage.getContent();
//        return promoCodeLists.stream()
//                .map(UserMapper.INSTANCE::toUserList)
//                .toList();
//    }
    }

    @Override
    public void updatePromoCode(UUID id, PromoCodeRequest promoCodeRequest) {
        LOG.info("update promocode successfully");
        PromoCodeEntity promoCode = promoCodeRepository.findById(id).
                orElseThrow(() -> new RemitException(codes.pick("USR002")));


    }


}
