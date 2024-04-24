package com.swifttech.promocodeservice.service;

import com.swifttech.promocodeservice.entity.ServiceChargeEntity;
import com.swifttech.promocodeservice.payload.request.ServiceChargeRequest;

import java.util.UUID;

public interface ServiceChargeService {
   void createServiceCharge(ServiceChargeRequest serviceChargeRequest);

//   ServiceChargeEntity updateServiceCharge(UUID id, ServiceChargeRequest serviceChargeRequest);
//
//    void deleteServiceCharge(UUID id);
}
