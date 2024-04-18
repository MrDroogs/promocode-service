package com.swifttech.promocodeservice.controller;

import com.swifttech.promocodeservice.payload.request.AmountWiseRequest;
import com.swifttech.promocodeservice.payload.request.CustomerSegmentRequest;
import com.swifttech.promocodeservice.service.AmountWiseService;
import com.swifttech.promocodeservice.service.CustomerSegmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/amountWise")
public class AmountWiseController {
    private final AmountWiseService amountWiseService;
    @PostMapping("/create")
    public void createAmountWise(@RequestBody AmountWiseRequest amountWiseRequest){
        amountWiseService.createAmountWise(amountWiseRequest);
    }

}
