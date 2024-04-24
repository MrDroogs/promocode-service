package com.swifttech.promocodeservice.mapper;

import com.swifttech.promocodeservice.entity.CountWiseEntity;
import com.swifttech.promocodeservice.payload.request.CountWiseRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CountWiseMapper {
    CountWiseMapper Instance = Mappers.getMapper(CountWiseMapper.class);
    CountWiseEntity toEntity(CountWiseRequest countWiseRequest);

    CountWiseRequest toRequest(CountWiseEntity countWiseEntity);
}
