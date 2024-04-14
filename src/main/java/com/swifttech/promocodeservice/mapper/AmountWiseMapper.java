package com.swifttech.promocodeservice.mapper;

import com.swifttech.promocodeservice.entity.AmountWiseEntity;
import com.swifttech.promocodeservice.entity.PromoCodeEntity;
import com.swifttech.promocodeservice.payload.request.AmountWiseRequest;
import com.swifttech.promocodeservice.payload.request.PromoCodeRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AmountWiseMapper {
    AmountWiseMapper Instance = Mappers.getMapper(AmountWiseMapper.class);
    AmountWiseEntity toEntity(AmountWiseRequest amountWiseRequest);

    AmountWiseRequest toRequest(AmountWiseEntity amountWiseEntity);
}
