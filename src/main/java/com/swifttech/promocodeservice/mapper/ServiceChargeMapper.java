package com.swifttech.promocodeservice.mapper;

import com.swifttech.promocodeservice.entity.ServiceChargeEntity;
import com.swifttech.promocodeservice.payload.request.ServiceChargeRequest;
import org.mapstruct.factory.Mappers;

public interface ServiceChargeMapper {
    ServiceChargeMapper Instance = Mappers.getMapper(ServiceChargeMapper.class);
    ServiceChargeEntity toEntity(ServiceChargeRequest serviceChargeRequest);

    ServiceChargeRequest toRequest(ServiceChargeEntity serviceChargeEntity);
}
