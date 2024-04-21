package com.swifttech.promocodeservice.controller;

import com.swifttech.promocodeservice.core.builder.ServiceResponseBuilder;
import com.swifttech.promocodeservice.core.model.Response;
import com.swifttech.promocodeservice.payload.request.ServiceChargeRequest;
import com.swifttech.promocodeservice.service.ServiceChargeService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/servicecharge")
public class ServiceChargeController {
    private final ServiceChargeService serviceChargeService;
    private final MessageSource messageSource;

    @PostMapping("/create")
    public void createServiceCharge(@RequestBody ServiceChargeRequest serviceChargeRequest){
        serviceChargeService.createServiceCharge(serviceChargeRequest);
    }
    @PutMapping("/update")
    public ResponseEntity<Response> updateServiceCharge(@PathVariable UUID id, @RequestBody ServiceChargeRequest serviceChargeRequest) {
        serviceChargeService.updateServiceCharge(id,serviceChargeRequest);
        return ResponseEntity.ok(ServiceResponseBuilder.buildSuccessResponse(null,
                messageSource.getMessage("message.updatePromoCode.success", null, LocaleContextHolder.getLocale())));
    }
    @DeleteMapping("/promocode/{id}")
    public Mono<ResponseEntity<Response>> deleteServiceCharge(@PathVariable("id") UUID id) {
        serviceChargeService.deleteServiceCharge(id);
        return Mono.just(ResponseEntity.ok(ServiceResponseBuilder.buildSuccessResponse(
                messageSource.getMessage("message.service.charge.scheme.deleted.success",
                        null, LocaleContextHolder.getLocale()))));
    }


}
