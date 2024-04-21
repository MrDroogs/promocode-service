package com.swifttech.promocodeservice.mapper;

import com.swifttech.promocodeservice.entity.TimeFrameEntity;
import com.swifttech.promocodeservice.payload.request.TimeFrameRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TimeFrameMapper {
    TimeFrameMapper Instance = Mappers.getMapper(TimeFrameMapper.class);
     TimeFrameEntity toEntity(TimeFrameRequest timeFrameRequest);
     TimeFrameRequest toRequest(TimeFrameEntity timeFrameEntity);
}
