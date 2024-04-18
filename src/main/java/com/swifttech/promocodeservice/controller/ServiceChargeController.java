package com.swifttech.promocodeservice.controller;

import com.swifttech.promocodeservice.payload.request.ServiceChargeRequest;
import com.swifttech.promocodeservice.service.ServiceChargeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/servicecharge")
public class ServiceChargeController {
    private final ServiceChargeService serviceChargeService;
    @PostMapping("/create")
    public void createServiceCharge(@RequestBody ServiceChargeRequest serviceChargeRequest){
        serviceChargeService.createServiceCharge(serviceChargeRequest);
    }
}
