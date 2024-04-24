package com.swifttech.promocodeservice.service;

import com.swifttech.promocodeservice.entity.ServiceChargeEntity;
import com.swifttech.promocodeservice.entity.TimeFrameEntity;
import com.swifttech.promocodeservice.payload.request.ServiceChargeRequest;
import com.swifttech.promocodeservice.payload.request.TimeFrameRequest;

import java.util.UUID;

public interface TimeFrameService {


    void createTimeFrame(TimeFrameRequest timeFrameRequest);

//    TimeFrameEntity updateTimeFrame(UUID id, TimeFrameRequest timeFrameRequest);
//
//
//    void  deleteTimeFramew(UUID id);
}
