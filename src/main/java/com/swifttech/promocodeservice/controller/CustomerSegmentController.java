package com.swifttech.promocodeservice.controller;

import com.swifttech.promocodeservice.payload.request.CustomerSegmentRequest;
import com.swifttech.promocodeservice.service.CustomerSegmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/customerSegment")
public class CustomerSegmentController {
    private final CustomerSegmentService customerSegmentService;
    @PostMapping("/create")
    public void createCustomerSegment(@RequestBody CustomerSegmentRequest customerSegmentRequest){
        customerSegmentService.createCustomerSegment(customerSegmentRequest);
    }


}
