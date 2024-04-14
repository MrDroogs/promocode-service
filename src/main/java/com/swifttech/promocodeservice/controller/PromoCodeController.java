package com.swifttech.promocodeservice.controller;

import com.swifttech.promocodeservice.payload.request.PromoCodeRequest;
import com.swifttech.promocodeservice.service.PromoCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/promoCode")
public class PromoCodeController {
    private final PromoCodeService promoCodeService;


    @PostMapping("/create")
    public void createPromoCode(@RequestBody  PromoCodeRequest promoCodeRequest){
      promoCodeService.createPromoCode(promoCodeRequest);
    }
}
