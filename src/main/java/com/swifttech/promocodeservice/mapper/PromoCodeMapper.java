package com.swifttech.promocodeservice.mapper;

import com.swifttech.promocodeservice.entity.PromoCodeEntity;
import com.swifttech.promocodeservice.payload.request.PromoCodeRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PromoCodeMapper {
    PromoCodeMapper Instance = Mappers.getMapper(PromoCodeMapper.class);

    PromoCodeEntity toEntity(PromoCodeRequest promoCodeRequest);

    PromoCodeRequest toRequest(PromoCodeEntity promoCodeEntity);






}
