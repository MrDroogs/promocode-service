package com.swifttech.promocodeservice.service;

import com.swifttech.promocodeservice.payload.request.PromoCodeRequest;

public interface PromoCodeService {

    public void createPromoCode(PromoCodeRequest promoCodeRequest);
}
