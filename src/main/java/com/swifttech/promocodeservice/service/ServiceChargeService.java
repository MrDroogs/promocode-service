package com.swifttech.promocodeservice.service;

import com.swifttech.promocodeservice.entity.ServiceChargeEntity;
import com.swifttech.promocodeservice.payload.request.ServiceChargeRequest;

public interface ServiceChargeService {
   void createServiceCharge(ServiceChargeRequest serviceChargeRequest);
}
