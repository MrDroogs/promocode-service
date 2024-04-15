package com.swifttech.promocodeservice.mapper;

import com.swifttech.promocodeservice.entity.PromoCodeEntity;
import com.swifttech.promocodeservice.payload.request.PromoCodeRequest;
import com.swifttech.promocodeservice.payload.response.PromoCodeList;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PromoCodeMapper {
    PromoCodeMapper Instance = Mappers.getMapper(PromoCodeMapper.class);

    PromoCodeEntity toEntity(PromoCodeRequest promoCodeRequest);

    PromoCodeRequest toRequest(PromoCodeEntity promoCodeEntity);

    PromoCodeList toList(PromoCodeEntity promoCodeEntity);

//    default List<String> getPromoCodes(PromoCodeEntity entity){
//        return entity.getPromoCodeName()
//                .stream()
//                .map(PromoCodeEntity::getPromoCodeName)
//                .Collect(Collectors.toList());
//    }






}
