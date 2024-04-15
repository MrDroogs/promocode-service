package com.swifttech.promocodeservice.service;

import com.swifttech.promocodeservice.payload.request.PromoCodeRequest;
import com.swifttech.promocodeservice.payload.response.PromoCodeList;

import java.util.List;
import java.util.UUID;

public interface PromoCodeService {

    void createPromoCode(PromoCodeRequest promoCodeRequest);

    List<PromoCodeList> promoCodeList(PromoCodeRequest promoCodeRequest);
    void updatePromoCode(UUID id, PromoCodeRequest promoCodeRequest);

//    public boolean isPromoCodeExpired(PromoCodeEntity promoCode);
}
