package com.swifttech.promocodeservice.service.impl;

import com.swifttech.promocodeservice.core.base.Codes;
import com.swifttech.promocodeservice.core.exception.RemitException;
import com.swifttech.promocodeservice.entity.ServiceChargeEntity;
import com.swifttech.promocodeservice.mapper.ServiceChargeMapper;
import com.swifttech.promocodeservice.payload.request.ServiceChargeRequest;
import com.swifttech.promocodeservice.repository.ServiceChargeRepository;
import com.swifttech.promocodeservice.service.ServiceChargeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ServiceChargeImpl implements ServiceChargeService {
    private final Codes codes;
    private final ServiceChargeRepository serviceChargeRepository;


    @Override
    public void createServiceCharge(ServiceChargeRequest serviceChargeRequest) {
        serviceChargeRepository.findByType(serviceChargeRequest.getType());
        ServiceChargeEntity serviceChargeEntity = ServiceChargeMapper.Instance.toEntity(serviceChargeRequest);
        serviceChargeEntity.setType(serviceChargeRequest.getType());
        serviceChargeEntity.setValue(serviceChargeRequest.getValue());
        serviceChargeRepository.save(serviceChargeEntity);
    }

    @Override
    public ServiceChargeEntity updateServiceCharge(UUID id, ServiceChargeRequest serviceChargeRequest) {
        ServiceChargeEntity serviceChargeEntity = serviceChargeRepository.findById(id).orElseThrow(()
                -> new RemitException(codes.pick("PRM001")));
        ServiceChargeMapper.Instance.toRequest(serviceChargeEntity);
        return serviceChargeRepository.save(serviceChargeEntity);
    }

    @Override
    public void deleteServiceCharge(UUID id) {
        Optional<ServiceChargeEntity> serviceChargeId = serviceChargeRepository.findById(id);
        if (serviceChargeId.isPresent()) {
            ServiceChargeEntity serviceCharge = serviceChargeId.get();
            serviceChargeRepository.save(serviceCharge);
        }
    }


}
