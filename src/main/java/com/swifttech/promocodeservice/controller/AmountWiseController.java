package com.swifttech.promocodeservice.controller;

import com.swifttech.promocodeservice.payload.request.AmountWiseRequest;
import com.swifttech.promocodeservice.payload.request.CountWiseRequest;
import com.swifttech.promocodeservice.service.AmountCountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/amountWise")
public class AmountWiseController {
    private final AmountCountService amountCountService;
    @PostMapping("/create")
    public void createAmountWise(@RequestBody AmountWiseRequest amountWiseRequest){
        amountCountService.createAmountWise(amountWiseRequest);
    }
    @PostMapping("/creatCount")
    public void createCountWise(@RequestBody CountWiseRequest countWiseRequest){
        amountCountService.createCountWise(countWiseRequest);

    }

}
