package com.swifttech.promocodeservice.mapper;

import com.swifttech.promocodeservice.entity.CustomerSegmentEntity;
import com.swifttech.promocodeservice.payload.request.CustomerSegmentRequest;
import org.mapstruct.factory.Mappers;

public interface CustomerSegmentMapper {
    CustomerSegmentMapper Instance = Mappers.getMapper(CustomerSegmentMapper.class);
    CustomerSegmentEntity toEntity(CustomerSegmentRequest customerSegmentRequest);

    CustomerSegmentRequest toRequest(CustomerSegmentEntity customerSegmentEntity);

}
