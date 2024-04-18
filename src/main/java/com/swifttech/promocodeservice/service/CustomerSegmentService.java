package com.swifttech.promocodeservice.service;

import com.swifttech.promocodeservice.payload.request.CustomerSegmentRequest;

public interface CustomerSegmentService {

    void createCustomerSegment(CustomerSegmentRequest customerSegmentRequest);

}
