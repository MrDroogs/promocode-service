package com.swifttech.promocodeservice.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.swifttech.promocodeservice.core.base.Codes;
import com.swifttech.promocodeservice.core.exception.RemitException;
import com.swifttech.promocodeservice.core.model.ApiError;
import com.swifttech.promocodeservice.core.model.ApiResponse;
import com.swifttech.promocodeservice.core.records.CodeRecord;
import com.swifttech.promocodeservice.payload.request.CountryApiRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j

public class InterCommunication {
    private final WebClient.Builder webClient;
    private final Codes codes;
   private  static Mono<? extends Throwable> apply (ClientResponse clientResponse){
       return clientResponse.bodyToMono(String.class)
               .flatMap(body -> {
                   try {
                       ApiError errorResponse = new ObjectMapper().readValue(body, ApiError.class);
                       return Mono.error(new RemitException(new CodeRecord("", errorResponse.getMessage())));
                   } catch (IOException e) {
                       return Mono.error(new RemitException(new CodeRecord("", body)));
                   }
               });

   }


}
