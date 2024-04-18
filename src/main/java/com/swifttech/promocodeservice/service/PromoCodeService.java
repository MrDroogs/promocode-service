package com.swifttech.promocodeservice.service;

import com.swifttech.promocodeservice.entity.PromoCodeEntity;
import com.swifttech.promocodeservice.payload.request.PaginationRequest;
import com.swifttech.promocodeservice.payload.request.PromoCodeRequest;
import com.swifttech.promocodeservice.payload.response.PromoCodeList;

import java.util.List;
import java.util.UUID;

public interface PromoCodeService {

    void createPromoCode(PromoCodeRequest promoCodeRequest);

//    void updatePromoCode(PromoCodeRequest promoCodeRequest);
//
//    PromoCodeEntity update(PromoCodeRequest promoCodeRequest);





}
