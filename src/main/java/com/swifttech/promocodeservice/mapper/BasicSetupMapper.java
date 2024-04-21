package com.swifttech.promocodeservice.mapper;

import com.swifttech.promocodeservice.entity.BasicSetupEntity;
import com.swifttech.promocodeservice.payload.request.BasicSetupRequest;
import com.swifttech.promocodeservice.payload.response.PromoCodeList;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BasicSetupMapper {
    BasicSetupMapper Instance = Mappers.getMapper(BasicSetupMapper.class);

    BasicSetupEntity toEntity(BasicSetupRequest basicSetupRequest);

    BasicSetupRequest toRequest(BasicSetupEntity basicSetupEntity);

    PromoCodeList toPromoCodeList(BasicSetupEntity basicSetupEntity);





}
