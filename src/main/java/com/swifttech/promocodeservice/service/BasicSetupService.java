package com.swifttech.promocodeservice.service;

import com.swifttech.promocodeservice.payload.request.PaginationRequest;
import com.swifttech.promocodeservice.payload.request.BasicSetupRequest;
import com.swifttech.promocodeservice.payload.response.PromoCodeList;

import java.util.List;
import java.util.UUID;

public interface BasicSetupService {

    void createPromoCode(BasicSetupRequest basicSetupRequest);

    void updatePromoCode(UUID id, BasicSetupRequest basicSetupRequest);

    List<PromoCodeList> promoCodeList(PaginationRequest pagination);


    void deletePromoCode(UUID id);
}
