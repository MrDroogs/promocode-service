package com.swifttech.promocodeservice.mapper;

import com.swifttech.promocodeservice.entity.PromoCodeEntity;
import com.swifttech.promocodeservice.payload.request.PromoCodeRequest;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PromoCodeMapper {
    PromoCodeMapper Instance = Mappers.getMapper(PromoCodeMapper.class);

    PromoCodeEntity toEntity(PromoCodeRequest request);

   @Mapping(target = "id",ignore = true)
    PromoCodeRequest mapToRequest(PromoCodeRequest request, @MappingTarget PromoCodeEntity entity);



}
