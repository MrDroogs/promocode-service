package com.swifttech.promocodeservice.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.swifttech.promocodeservice.core.base.Codes;
import com.swifttech.promocodeservice.core.exception.RemitException;
import com.swifttech.promocodeservice.core.model.ApiError;
import com.swifttech.promocodeservice.core.model.ApiResponse;
import com.swifttech.promocodeservice.core.records.CodeRecord;
import com.swifttech.promocodeservice.payload.request.CountryApiRequest;
import com.swifttech.promocodeservice.payload.response.CountryResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
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
    public List<CountryResponse> getCountry(List<UUID> countryId) {
        return webClient.build()
                .post()
                .uri("https://uat-gateway.swifttech.com.np/api/v2/master/country/byId")
                .bodyValue(countryId)
                .retrieve()
                .onStatus(HttpStatusCode::isError, InterCommunication::apply)
                .bodyToFlux(CountryResponse.class)
                .collectList()
                .block();
    }
    public ApiResponse getCurrency(List<UUID> currencyId){
       return webClient.build()
                   .post()
                   .uri("https://uat-gateway.swifttech.com.np/api/v2/master/currency/byIds")
                    .bodyValue(currencyId)
                   .retrieve()
                   .onStatus(HttpStatusCode::isError, InterCommunication::apply)
                   .bodyToMono(ApiResponse.class)
                   .block();

       }

    public ApiResponse getApplicableDays(List<UUID> applicableDays) {
       return webClient.build()
               .post()
               .uri("")
               .bodyValue(applicableDays)
               .retrieve()
               .onStatus(HttpStatusCode::isError,InterCommunication::apply)
               .bodyToMono(ApiResponse.class)
               .block();
    }



}



