package com.swifttech.promocodeservice.payload.request;

import com.swifttech.promocodeservice.enums.Gender;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Builder
public class CustomerSegmentRequest {
    private String kycStatus;
    private Gender gender;
    private List<String> nationality;
    private String age;
    private String visaType;
}
