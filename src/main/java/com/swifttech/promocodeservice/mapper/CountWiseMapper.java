package com.swifttech.promocodeservice.mapper;

import com.swifttech.promocodeservice.entity.CountWiseEntity;
import com.swifttech.promocodeservice.payload.request.CountWiseRequest;
import org.mapstruct.factory.Mappers;

public interface CountWiseMapper {
    CountWiseMapper Instance = Mappers.getMapper(CountWiseMapper.class);
    CountWiseEntity toEntity(CountWiseRequest countWiseRequest);

    CountWiseRequest toRequest(CountWiseEntity countWiseEntity);
}
