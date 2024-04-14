package com.swifttech.promocodeservice.payload.request;

public record PaginationRequest(Integer pages, Integer size, String sortBy, String sortDirection) {
}
