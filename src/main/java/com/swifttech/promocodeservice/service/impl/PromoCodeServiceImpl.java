package com.swifttech.promocodeservice.service.impl;

import com.swifttech.promocodeservice.core.base.Codes;
import com.swifttech.promocodeservice.core.model.ApiResponse;
import com.swifttech.promocodeservice.entity.PromoCodeEntity;
import com.swifttech.promocodeservice.mapper.PromoCodeMapper;
import com.swifttech.promocodeservice.payload.request.PromoCodeRequest;
import com.swifttech.promocodeservice.repository.CustomerRepository;
import com.swifttech.promocodeservice.repository.PromoCodeRepository;
import com.swifttech.promocodeservice.service.PromoCodeService;
import com.swifttech.promocodeservice.util.DataValidation;
import com.swifttech.promocodeservice.util.InterCommunication;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
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
    public void createPromoCode(PromoCodeRequest promoCodeRequest)  {
    PromoCodeEntity promoCode = promoCodeRepository.findByPromoCodeName(promoCodeRequest.getPromoCodeName());
    promoCode = PromoCodeMapper.Instance.toEntity(promoCodeRequest);




//        PromoCodeEntity promoCode = promoCodeRepository.findByPromoCodeName(promoCodeRequest.getPromoCodeName());
//
//
//        promoCode = PromoCodeEntity.builder()
//                .promoCodeName(promoCodeRequest.getPromoCodeName())
//                .promoCodeDescription(promoCodeRequest.getPromoCodeDescription())
//                .applicableForTransaction(promoCodeRequest.getApplicableForTransaction())
//                .build();
//
//        if (!promoCodeRequest.getApplicableForTransaction()) {
//            promoCode = promoCode.builder()
//                    .applicableDays(promoCodeRequest.getApplicableDays())
//                    .startDate(promoCodeRequest.getStartDate())
//                    .endDate(promoCodeRequest.getEndDate())
//                    .startTime(promoCodeRequest.getStartTime())
//                    .endTime(promoCodeRequest.getEndTime())
//                    .build();
//
//        if (promoCodeRequest.getSpecifiedTime()) {
//            promoCode=promoCode.builder()
//                    .startTime(promoCodeRequest.getStartTime())
//                    .endTime(promoCodeRequest.getEndTime())
//                    .build();
//        }
//
//        } else {
//            promoCode = promoCode.builder()
//                    .receivingCountry(promoCodeRequest.getReceivingCountry())
//                    .sendingCountry(promoCodeRequest.getSendingCountry())
//                    .currency(promoCodeRequest.getCurrency())
//                    .startDate(promoCodeRequest.getStartDate())
//                    .endDate(promoCodeRequest.getEndDate())
//                    .applicableDays(promoCodeRequest.getApplicableDays())
//                    .specifiedTime(promoCodeRequest.getSpecifiedTime())
//                    .startTime(promoCodeRequest.getStartTime())
//                    .endTime(promoCodeRequest.getEndTime())
//                    .build();
//        }
//
//        promoCodeRepository.save(promoCode);
    }




//    @Override
//    public List<PromoCodeList> promoCodeList(PaginationRequest paginationRequest) {
//       List<PromoCodeEntity> promoCodeEntities = promoCodeRepository.findAll();
//       return promoCodeEntities.stream()
//               .map(PromoCodeMapper.Instance::toList)
//               .toList();
//
//    }


//package com.swifttech.partnerservice.service.impl;
//
//import com.swifttech.partnerservice.core.base.Codes;
//import com.swifttech.partnerservice.core.exception.RemitException;
//import com.swifttech.partnerservice.core.model.ApiResponse;
//import com.swifttech.partnerservice.core.records.CodeRecord;
//import com.swifttech.partnerservice.entity.*;
//import com.swifttech.partnerservice.enums.Status;
//import com.swifttech.partnerservice.mapper.PartnerMapper;
//import com.swifttech.partnerservice.payload.request.*;
//import com.swifttech.partnerservice.payload.response.*;
//import com.swifttech.partnerservice.repository.*;
//import com.swifttech.partnerservice.service.PartnerService;
//import com.swifttech.partnerservice.service.specification.PartnerSpecification;
//import com.swifttech.partnerservice.utils.InterCommunication;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.modelmapper.ModelMapper;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.domain.Specification;
//import org.springframework.stereotype.Service;
//import reactor.core.publisher.Mono;
//
//import java.time.LocalDateTime;
import java.util.*;

    /*
     * @Created At 15/03/2024
     * @Author ashim.gotame
     */

    @Service
    @RequiredArgsConstructor
    @Slf4j
    public class PartnerServiceImpl implements PartnerService {

        private final PartnerRepository partnerRepository;
        private final PartnerMapper partnerMapper;
        private final PartnerPaymentModeRepository partnerPaymentModeRepository;
        private final PartnerCorridorsRepository partnerCorridorsRepository;
        private final PartnerDocumentRepository partnerDocumentRepository;
        private final InterCommunication interCommunication;
        private final PartnerPriorityRepository partnerPriorityRepository;
        private final Codes codes;

        private static final String FOLDER_SEPERATOR = "/";

        @Override
        public PartnerEntity addPartner(PartnerRequestDto partnerRequestDto) {
            log.info("Creating new partner");
            validate(partnerRequestDto);
            PartnerAddressEntity partnerAddress = PartnerMapper.INSTANCE.toEntity(partnerRequestDto.getGeneral()
                    .getAddress());
            PartnerContactDetailEntity contactDetail = PartnerMapper.INSTANCE.toEntity(partnerRequestDto.getGeneral()
                    .getContactDetails());
            PartnerConfigEntity partnerConfigEntity = partnerMapper.toEntity(partnerRequestDto.getConfiguration());
            PartnerAccountEntity partnerAccountEntity = partnerMapper.toEntity(partnerRequestDto.getAccount());
            List<PartnerPaymentModeEntity> partnerPaymentModeEntities =
                    partnerMapper.toEntity(partnerRequestDto.getPaymentModes());
            List<PartnerCorridorsEntity> corridorsEntities = new ArrayList<>();
            corridorsEntities.addAll(partnerMapper.toEntities(partnerRequestDto.getCorridors()));
            List<PartnerDocumentEntity> partnerDocumentEntities = new ArrayList<>();
            partnerDocumentEntities.addAll(partnerRequestDto.getGeneral()
                    .getDocuments()
                    .stream()
                    .parallel()
                    .map(e -> {
                        String path = "partner" + FOLDER_SEPERATOR + partnerRequestDto.getGeneral()
                                .getPartnerAlias() + FOLDER_SEPERATOR + "DOCUMENTS";
                        BucketRequestRecord bucketRequestRecord = new BucketRequestRecord(e.encodedData(), path, "a");
                        PartnerDocumentEntity partnerDocument = new PartnerDocumentEntity();
                        Mono<ApiResponse> apiResponse = interCommunication.generateFilePath(bucketRequestRecord);
                        ApiResponse response = apiResponse.block();
                        partnerDocument.setFilePath((String) response.getData());
                        return partnerDocumentRepository.save(partnerDocument);
                    })
                    .toList());
            PartnerEntity partner = PartnerEntity.builder()
                    .partnerLegalName(partnerRequestDto.getGeneral()
                            .getPartnerLegalName())
                    .partnerAlias(partnerRequestDto.getGeneral()
                            .getPartnerAlias())
                    .registrationType(partnerRequestDto.getGeneral()
                            .getRegistrationType())
                    .serviceType(partnerRequestDto.getGeneral()
                            .getServiceType())
                    .externalCode(partnerRequestDto.getGeneral()
                            .getExternalCode())
                    .enablePartner(partnerRequestDto.getGeneral()
                            .getIsEnablePartner())
                    .configuration(partnerConfigEntity)
                    .account(partnerAccountEntity)
                    .paymentModes(partnerPaymentModeEntities)
                    .corridors(corridorsEntities)
                    .documents(partnerDocumentEntities)
                    .address(partnerAddress)
                    .contactDetail(contactDetail)
                    .build();
            String path = "partner" + FOLDER_SEPERATOR + partnerRequestDto.getGeneral()
                    .getPartnerLegalName() + FOLDER_SEPERATOR + "LOGO";
            String filename = LocalDateTime.now() + "_" + partnerRequestDto.getGeneral()
                    .getPartnerAlias();
            BucketRequestRecord bucketRequestRecord = new BucketRequestRecord(partnerRequestDto.getGeneral()
                    .getPartnerLogo(), path, filename);
            Mono<ApiResponse> apiResponse = interCommunication.generateFilePath(bucketRequestRecord);
            ApiResponse response = apiResponse.block();
            assert response != null;
            partner.setPartnerLogo((String) response.getData());
            partner.setStatus(Status.ACTIVE);
            List<PartnerPriorityEntity> partnerPriorityEntities = this.partnerPriorityRepository.findByCountryId(partnerRequestDto.getGeneral().getAddress().getCountryId());
            PartnerEntity newPartner = this.partnerRepository.save(partner);
            PartnerPriorityEntity partnerPriority = new PartnerPriorityEntity();
            partnerPriority.setPartnerId(newPartner.getId());
            partnerPriority.setCountryId(newPartner.getAddress().getCountryId());
            partnerPriority.setOrderOfPriority(partnerPriorityEntities.size() + 1);
            this.partnerPriorityRepository.save(partnerPriority);
            return  newPartner;

        }

        @Override
        public PartnerEntity updatePartner(PartnerRequestDto partnerRequestDto) {
            log.info("Updating partner by partner id:{}",partnerRequestDto.getId());
            validate(partnerRequestDto);
            Optional<PartnerEntity> partnerEntity = this.partnerRepository.findById(partnerRequestDto.getId());
            if (partnerEntity.isEmpty()) {
                throw new RemitException(codes.pick("PAR001"));
            }
            PartnerAddressEntity partnerAddress = PartnerMapper.INSTANCE.toEntity(partnerRequestDto.getGeneral()
                    .getAddress());
            PartnerContactDetailEntity contactDetail = PartnerMapper.INSTANCE.toEntity(partnerRequestDto.getGeneral()
                    .getContactDetails());
            PartnerConfigEntity partnerConfigEntity = partnerMapper.toEntity(partnerRequestDto.getConfiguration());
            PartnerAccountEntity partnerAccountEntity = partnerMapper.toEntity(partnerRequestDto.getAccount());
            List<PartnerPaymentModeEntity> partnerPaymentModeEntities =
                    partnerMapper.toEntity(partnerRequestDto.getPaymentModes());
            List<PartnerCorridorsEntity> corridorsEntities = new ArrayList<>();
            Result result = new Result(partnerAddress, contactDetail, partnerConfigEntity, partnerAccountEntity,
                    partnerPaymentModeEntities, corridorsEntities);
            result.corridorsEntities()
                    .addAll(partnerMapper.toEntities(partnerRequestDto.getCorridors()));
            partnerEntity.get()
                    .setPartnerLegalName(partnerRequestDto.getGeneral()
                            .getPartnerLegalName());
            partnerEntity.get()
                    .setPartnerAlias(partnerRequestDto.getGeneral()
                            .getPartnerAlias());
            partnerEntity.get()
                    .setRegistrationType(partnerRequestDto.getGeneral()
                            .getRegistrationType());
            partnerEntity.get()
                    .setServiceType(partnerRequestDto.getGeneral()
                            .getServiceType());
            partnerEntity.get()
                    .setExternalCode(partnerRequestDto.getGeneral()
                            .getExternalCode());
            partnerEntity.get()
                    .setEnablePartner(partnerRequestDto.getGeneral()
                            .getIsEnablePartner());
            partnerEntity.get()
                    .setAccount(result.partnerAccountEntity());
            partnerEntity.get()
                    .setConfiguration(result.partnerConfigEntity());

            partnerEntity.get()
                    .setPaymentModes(result.partnerPaymentModeEntities());
            partnerEntity.get().setStatus(Status.ACTIVE);

            return this.partnerRepository.save(partnerEntity.get());
        }

        private record Result(PartnerAddressEntity partnerAddress, PartnerContactDetailEntity contactDetail,
                              PartnerConfigEntity partnerConfigEntity, PartnerAccountEntity partnerAccountEntity,
                              List<PartnerPaymentModeEntity> partnerPaymentModeEntities,
                              List<PartnerCorridorsEntity> corridorsEntities) {

        }

        @Override
        public PartnerEntity getById(UUID id) {
            log.info("Fetching partner by partner id: {}",id);

            Optional<PartnerEntity> partnerEntity = this.partnerRepository.findById(id);
            if (partnerEntity.isPresent()) {
                return  partnerEntity.get();
            }
            throw new RemitException(codes.pick("PAR001"));
        }

        @Override
        public void changeStatusById(UUID id, Boolean status) {
            Optional<PartnerEntity> partnerEntity = this.partnerRepository.findById(id);
            if (partnerEntity.isPresent()){
                partnerEntity.get().setEnablePartner(status);
                this.partnerRepository.save(partnerEntity.get());
            }else{
                throw new RemitException(codes.pick("INF001"));
            }

        }

        @Override
        public List<PartnerResponseCustomDto> getAllPartners(FilterRequestCustomDto filterRequestCustomDto) {
            log.info("Fetching partner list");

            List<PartnerResponseCustomDto> partnerResponseCustomDtos = new ArrayList<>();
            Specification<PartnerEntity> spec = PartnerSpecification.getAllPartnersByFilter(filterRequestCustomDto);
            if (filterRequestCustomDto.getPageNo()== null || filterRequestCustomDto.getPageSize() == null){
                throw new RemitException(codes.pick("GEN004"));
            }
            Pageable pageable   = PageRequest.of(filterRequestCustomDto.getPageNo(), filterRequestCustomDto.getPageSize());
            List<PartnerEntity> partnerEntities = this.partnerRepository.findAll(spec,pageable)
                    .getContent();
            partnerEntities.forEach(e -> {
                PartnerResponseCustomDto partnerResponseCustomDto = PartnerResponseCustomDto.builder()
                        .partnerName(e.getPartnerLegalName())
                        .id(e.getId())
                        .creditLimit(e.getConfiguration()
                                .getCreditLimit())
                        .status(e.getEnablePartner())
                        .serviceType(e.getServiceType())
                        .countryId(e.getAddress()
                                .getCountryId())
                        .build();
                partnerResponseCustomDtos.add(partnerResponseCustomDto);
            });
            return partnerResponseCustomDtos;
        }

        @Override
        public List<PartnerPrecedenceResponse> getAllPartnerPrecedence() {
            log.info("Fetching all partner Precedence ");

            List<PartnerPrecedenceResponse> precedenceResponses = new ArrayList<>();
            List<PartnerEntity> partnerEntities = this.partnerRepository.findAll();
            Set<UUID> countries = new HashSet<>();
            for (PartnerEntity partnerEntity : partnerEntities) {
                countries.add(partnerEntity.getAddress()
                        .getCountryId());
            }
            for (UUID id : countries) {
                List<PartnerEntity> count = this.partnerRepository.findByAddress_CountryId(id);
                PartnerPrecedenceResponse partnerPrecedenceResponse = new PartnerPrecedenceResponse();
                partnerPrecedenceResponse.setPartnerCount(count.size());
                partnerPrecedenceResponse.setCountryId(id);
                precedenceResponses.add(partnerPrecedenceResponse);
            }
            return precedenceResponses;
        }

        @Override
        public List<PartnerPrecedenceListDto> getPartnerPrecedenceByCountry(UUID countryId,FilterRequestCustomDto filterRequestCustomDto) {
            List<PartnerPrecedenceListDto> partnerPrecedenceListDtos = new ArrayList<>();
            if (filterRequestCustomDto.getPageNo() == null || filterRequestCustomDto.getPageSize() == null){
                throw new RemitException(codes.pick("GEN004"));
            }
            Pageable pageable = PageRequest.of(filterRequestCustomDto.getPageNo(),filterRequestCustomDto.getPageSize());
            Specification<PartnerPriorityEntity> specification = PartnerSpecification.getAllPartnersPriorityByCountry(countryId);
            List<PartnerPriorityEntity> partnerPriorityEntities = this.partnerPriorityRepository.findAll(specification,pageable).getContent();
            partnerPriorityEntities.forEach(e->{
                Optional<PartnerEntity> partnerEntity = this.partnerRepository.findById(e.getPartnerId());
                if (partnerEntity.isPresent()){
                    PartnerPrecedenceListDto partnerPrecedenceListDto = new PartnerPrecedenceListDto();
                    partnerPrecedenceListDto.setPartnerName(partnerEntity.get().getPartnerLegalName());
                    partnerPrecedenceListDto.setStatus(partnerEntity.get().getStatus());
                    partnerPrecedenceListDto.setOrder(e.getOrderOfPriority());
                    partnerPrecedenceListDto.setPartnerId(e.getPartnerId());
                    partnerPrecedenceListDto.setId(e.getId());
                    partnerPrecedenceListDtos.add(partnerPrecedenceListDto);
                }
            });
            return partnerPrecedenceListDtos;
        }

        @Override
        public List<PartnerPrecedenceListDto> getPartnerPrecedenceByCountry(UUID countryId) {
            List<PartnerPrecedenceListDto> partnerPrecedenceListDtos = new ArrayList<>();

            Specification<PartnerPriorityEntity> specification = PartnerSpecification.getAllPartnersPriorityByCountry(countryId);
            List<PartnerPriorityEntity> partnerPriorityEntities = this.partnerPriorityRepository.findAll(specification);
            partnerPriorityEntities.forEach(e->{
                Optional<PartnerEntity> partnerEntity = this.partnerRepository.findById(e.getPartnerId());
                if (partnerEntity.isPresent()){
                    PartnerPrecedenceListDto partnerPrecedenceListDto = new PartnerPrecedenceListDto();
                    partnerPrecedenceListDto.setPartnerName(partnerEntity.get().getPartnerLegalName());
                    partnerPrecedenceListDto.setStatus(partnerEntity.get().getStatus());
                    partnerPrecedenceListDto.setOrder(e.getOrderOfPriority());
                    partnerPrecedenceListDto.setPartnerId(e.getPartnerId());
                    partnerPrecedenceListDto.setId(e.getId());
                    partnerPrecedenceListDtos.add(partnerPrecedenceListDto);
                }
            });
            return partnerPrecedenceListDtos;
        }

        @Override
        public void updateOrder(List<PartnerPrecedenceOrderRequestDto> partnerPrecedenceOrderRequestDtos) {
            List<PartnerPriorityEntity> partnerPriorityEntities = new ArrayList<>();
            partnerPrecedenceOrderRequestDtos.forEach(e->{
                Optional<PartnerPriorityEntity> partnerPriority = this.partnerPriorityRepository.findById(e.getId());
                if (partnerPriority.isPresent()){
                    partnerPriority.get().setOrderOfPriority(e.getOrder());
                    partnerPriorityEntities.add(partnerPriority.get());
                }
            });
            this.partnerPriorityRepository.saveAll(partnerPriorityEntities);
        }

        private void validate(PartnerRequestDto partnerRequestDto) {
            CountryListRequestDto countryListRequestDto = new CountryListRequestDto();
            List<PaymentModeRequestDto> paymentModes = partnerRequestDto.getPaymentModes();
            List<String> keyStrings = new ArrayList<>();
            keyStrings.add("PMT");
            log.info("validating partner create");
            ApiResponse apiResponse = interCommunication.getCategory(keyStrings);
            List<LinkedHashMap<String,String>> linkedHashMaps = (List<LinkedHashMap<String, String>>) apiResponse.getData();

            List<MasterCategoryResponse> data = linkedHashMaps.stream().map(e-> new ModelMapper().map(e,MasterCategoryResponse.class)).toList();
            List<MasterCategoryItemResponse> masterCategoryItemResponses = data.getFirst()
                    .getItems();
            paymentModes.forEach(e->{
                if (Boolean.FALSE.equals(isPaymentModeValid(e.getKey(),masterCategoryItemResponses))){
                    throw new RemitException(codes.pick("COS005"));
                }
            });
            List<UUID> countryIds = new ArrayList<>();
            CountryResponse response = interCommunication.getCountryAndCurrencyByCountryId(partnerRequestDto.getGeneral()
                    .getAddress()
                    .getCountryId());
            if (response == null) {
                throw new RemitException(codes.pick("CON001"));
            }
            partnerRequestDto.getCorridors()
                    .forEach(e -> {
                        countryIds.add(e.getCountryId());
                    });
            countryListRequestDto.setCountryIds(countryIds);
            List<CountryResponse> countryResponses =
                    interCommunication.getAllCountriesAndItsCurrencyByCountryIds(countryListRequestDto);
            if (countryResponses.size() >= 0) {
                partnerRequestDto.getCorridors()
                        .forEach(e -> {
                            Optional<CountryResponse> countryResponse = countryResponses.stream()
                                    .filter(b -> b.id()
                                            .equals(e.getCountryId()))
                                    .findFirst();
                            List<String> supportingCurrency = new ArrayList<>();
                            countryResponse.get()
                                    .supportedCurrency()
                                    .forEach(currency -> {
                                        supportingCurrency.add(currency.code());
                                    });
                            boolean isExists = checkIfExists(e.getSupportingCurrency(), supportingCurrency);
                            if (!isExists) {
                                throw new RemitException(codes.pick("CUR001"));
                            }
                        });
            }
        }

        private Boolean isPaymentModeValid(String key,
                                           List<MasterCategoryItemResponse> masterCategoryItemResponses) {
            return masterCategoryItemResponses.stream()
                    .anyMatch(e -> e.getKeyword().equals(key));
        }
        private boolean checkIfExists(List<String> supportingCurrencyFromRequest,
                                      List<String> supportingCurrencyFromCountry) {
            for (String code : supportingCurrencyFromRequest) {
                boolean found = false;
                for (String i : supportingCurrencyFromCountry) {
                    if (Objects.equals(code, i)) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    log.error("Invalid supporting currency");
                    return false;
                }
            }
            return true;
        }

    }





}
