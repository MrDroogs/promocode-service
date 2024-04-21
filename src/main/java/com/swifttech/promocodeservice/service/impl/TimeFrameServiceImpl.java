package com.swifttech.promocodeservice.service.impl;

import com.swifttech.promocodeservice.core.base.Codes;
import com.swifttech.promocodeservice.core.exception.RemitException;
import com.swifttech.promocodeservice.entity.TimeFrameEntity;
import com.swifttech.promocodeservice.mapper.TimeFrameMapper;
import com.swifttech.promocodeservice.payload.request.TimeFrameRequest;
import com.swifttech.promocodeservice.repository.TimeFrameRepository;
import com.swifttech.promocodeservice.service.TimeFrameService;
import com.swifttech.promocodeservice.util.DataValidation;
import com.swifttech.promocodeservice.util.InterCommunication;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class TimeFrameServiceImpl implements TimeFrameService {
    private static final Logger LOG = LoggerFactory.getLogger(TimeFrameServiceImpl.class);
    private final TimeFrameRepository timeFrameRepository;
    private final Codes codes;
    private final DataValidation dataValidation;
    private final InterCommunication interCommunication;

    @Override
    public void createTimeFrame(TimeFrameRequest timeFrameRequest) {
        TimeFrameEntity timeFrame = timeFrameRepository.findByStartDate(timeFrameRequest.getStartDate());


        Boolean specificTime = timeFrameRequest.getSpecificTime();
        if (specificTime == null) {
            specificTime = false;
        }

        if (timeFrame == null) {
            timeFrame = new TimeFrameEntity();
        }

        timeFrame.setStartDate(timeFrameRequest.getStartDate());
        timeFrame.setEndDate(timeFrameRequest.getEndDate());
        timeFrame.setSpecificTime(specificTime);

        if (specificTime) {
            timeFrame.setStartTime(timeFrameRequest.getStartTime());
            timeFrame.setEndTime(timeFrameRequest.getEndTime());
        } else {
            timeFrame.setStartTime(null);
            timeFrame.setEndTime(null);
        }

//            List<UUID> applicableDays = new ArrayList<>();
//            UUID applicableDay = timeFrameRequest.getApplicableDays();
//            if (applicableDay != null) {
//                applicableDays.add(applicableDay);
//            }

//            log.info("Days REQUEST DATA {}", new Gson().toJson(applicableDays));
//            interCommunication.getApplicableDays(applicableDays);

        timeFrameRepository.save(timeFrame);
    }

    @Override
    public TimeFrameEntity updateTimeFrame(UUID id, TimeFrameRequest timeFrameRequest) {
        TimeFrameEntity timeFrameEntity = timeFrameRepository.findById(id).orElseThrow(()
                -> new RemitException(codes.pick("PRM001")));
        TimeFrameMapper.Instance.toRequest(timeFrameEntity);
        return timeFrameRepository.save(timeFrameEntity);
    }

    @Override
    public void deleteTimeFramew(UUID id) {
        Optional<TimeFrameEntity> timeFrameId = timeFrameRepository.findById(id);
        if (timeFrameId.isPresent()) {
            TimeFrameEntity timeFrame = timeFrameId.get();
            timeFrameRepository.save(timeFrame);
        }
    }
}
