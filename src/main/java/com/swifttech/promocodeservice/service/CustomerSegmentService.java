package com.swifttech.promocodeservice.service;

import com.swifttech.promocodeservice.entity.CustomerSegmentEntity;
import com.swifttech.promocodeservice.payload.request.CustomerSegmentRequest;

import java.util.UUID;

public interface CustomerSegmentService {

    void createCustomerSegment(CustomerSegmentRequest customerSegmentRequest);

    CustomerSegmentEntity updateCustomerSegment(UUID id, CustomerSegmentRequest customerSegmentRequest);

    void deleteCustomerSegment(UUID id);
}
