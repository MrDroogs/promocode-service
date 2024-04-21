package com.swifttech.promocodeservice.controller;

import com.swifttech.promocodeservice.core.builder.ServiceResponseBuilder;
import com.swifttech.promocodeservice.core.model.Response;
import com.swifttech.promocodeservice.payload.request.CustomerSegmentRequest;
import com.swifttech.promocodeservice.service.CustomerSegmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/customerSegment")
public class CustomerSegmentController {
    private final CustomerSegmentService customerSegmentService;
    private final MessageSource messageSource;

    @PostMapping("/create")
    public void createCustomerSegment(@RequestBody CustomerSegmentRequest customerSegmentRequest) {
        customerSegmentService.createCustomerSegment(customerSegmentRequest);
    }

//    @PutMapping("/update")
//    public ResponseEntity<Response> updateCustomerSegment(@PathVariable UUID id, @RequestBody CustomerSegmentRequest customerSegmentRequest) {
//        customerSegmentService.updateCustomerSegment(id, customerSegmentRequest);
//        return ResponseEntity.ok(ServiceResponseBuilder.buildSuccessResponse(null,
//                messageSource.getMessage("message.updatePromoCode.success", null, LocaleContextHolder.getLocale())));
//    }
//
//    @DeleteMapping("/customer/{id}")
//    public Mono<ResponseEntity<Response>> deleteCustomerSegment(@PathVariable("id") UUID id) {
//        customerSegmentService.deleteCustomerSegment(id);
//        return Mono.just(ResponseEntity.ok(ServiceResponseBuilder.buildSuccessResponse(
//                messageSource.getMessage("message.service.charge.scheme.deleted.success",
//                        null, LocaleContextHolder.getLocale()))));

//
//    }
}
