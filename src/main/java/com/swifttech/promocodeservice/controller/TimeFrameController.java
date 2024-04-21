package com.swifttech.promocodeservice.controller;

import com.swifttech.promocodeservice.core.builder.ServiceResponseBuilder;
import com.swifttech.promocodeservice.core.model.Response;
import com.swifttech.promocodeservice.payload.request.TimeFrameRequest;
import com.swifttech.promocodeservice.service.TimeFrameService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/timeframe")
public class TimeFrameController {
   private final TimeFrameService timeFrameService;
   private final MessageSource messageSource;

    @PostMapping("/create")
    public void createTimeFrame(@RequestBody TimeFrameRequest timeFrameRequest){
        timeFrameService.createTimeFrame(timeFrameRequest);
    }

    @PutMapping("/update")
    public ResponseEntity<Response> updateTimeFrame(@PathVariable UUID id, @RequestBody TimeFrameRequest timeFrameRequest) {
        timeFrameService.updateTimeFrame(id,timeFrameRequest);
        return ResponseEntity.ok(ServiceResponseBuilder.buildSuccessResponse(null,
                messageSource.getMessage("message.updatePromoCode.success", null, LocaleContextHolder.getLocale())));
    }
    @DeleteMapping("/promocode/{id}")
    public Mono<ResponseEntity<Response>> deleteTimeFrame(@PathVariable("id") UUID id) {
        timeFrameService.deleteTimeFramew(id);
        return Mono.just(ResponseEntity.ok(ServiceResponseBuilder.buildSuccessResponse(
                messageSource.getMessage("message.service.charge.scheme.deleted.success",
                        null, LocaleContextHolder.getLocale()))));
    }
}
