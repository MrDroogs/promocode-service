package com.swifttech.promocodeservice.controller;

import com.swifttech.promocodeservice.entity.PromoCodeEntity;
import com.swifttech.promocodeservice.payload.request.PromoCodeRequest;
import com.swifttech.promocodeservice.payload.response.PromoCodeList;
import com.swifttech.promocodeservice.service.PromoCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/promoCode")
public class PromoCodeController {
    private final PromoCodeService promoCodeService;


    @PostMapping("/create")
    public void createPromoCode(@RequestBody PromoCodeRequest promoCodeRequest){
      promoCodeService.createPromoCode(promoCodeRequest);
    }

}
