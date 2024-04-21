package com.swifttech.promocodeservice.controller;

import com.swifttech.promocodeservice.core.builder.ServiceResponseBuilder;
import com.swifttech.promocodeservice.core.model.Response;
import com.swifttech.promocodeservice.payload.request.BasicSetupRequest;
import com.swifttech.promocodeservice.payload.request.PaginationRequest;
import com.swifttech.promocodeservice.service.BasicSetupService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/promoCode")
public class BasicSetupController {
    private final BasicSetupService basicSetupService;
    private final MessageSource messageSource;


    @PostMapping("/create")
    public void createPromoCode(@RequestBody BasicSetupRequest basicSetupRequest){
      basicSetupService.createPromoCode(basicSetupRequest);
    }

    @PutMapping("/update")
    public ResponseEntity<Response> updatePromoCode(@PathVariable UUID id,@RequestBody BasicSetupRequest basicSetupRequest) {
       basicSetupService.updatePromoCode(id, basicSetupRequest);
        return ResponseEntity.ok(ServiceResponseBuilder.buildSuccessResponse(null,
                messageSource.getMessage("message.updatePromoCode.success", null, LocaleContextHolder.getLocale())));
    }
    @PostMapping("/promoCode/list")
    public Mono<ResponseEntity<Response>> promoCodeList(@RequestBody PaginationRequest pagination) {
        return Mono.just(
                ResponseEntity.ok(ServiceResponseBuilder.buildSuccessResponse(basicSetupService.promoCodeList(pagination))));
    }

    @DeleteMapping("/promocode/{id}")
    public Mono<ResponseEntity<Response>> deletePromoCode(@PathVariable("id") UUID id) {
        basicSetupService.deletePromoCode(id);
        return Mono.just(ResponseEntity.ok(ServiceResponseBuilder.buildSuccessResponse(
                messageSource.getMessage("message.service.charge.scheme.deleted.success",
                        null, LocaleContextHolder.getLocale()))));
    }


}
