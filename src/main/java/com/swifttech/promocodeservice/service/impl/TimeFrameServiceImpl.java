package com.swifttech.promocodeservice.service.impl;

import com.swifttech.promocodeservice.core.base.Codes;
import com.swifttech.promocodeservice.repository.TimeFrameRepository;
import com.swifttech.promocodeservice.service.TimeFrameService;
import com.swifttech.promocodeservice.util.DataValidation;
import com.swifttech.promocodeservice.util.InterCommunication;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TimeFrameServiceImpl implements TimeFrameService {
    private static final Logger LOG = LoggerFactory.getLogger(TimeFrameServiceImpl.class);
    private final TimeFrameRepository timeFrameRepository;
    private final Codes codes;
    private final DataValidation dataValidation;
    private final InterCommunication interCommunication;

//    @Override
//    public void CreateTimeFrame(TimeFrameRequest timeFrameRequest) {
//    TimeFrameEntity timeFrame=Time
//    }
}
