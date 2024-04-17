package com.swifttech.promocodeservice.payload.request;

import com.swifttech.promocodeservice.enums.Gender;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class CustomerSegmentRequest {
    private String kycStatus;
    private Gender gender;
    private List<String> Nationality;
    private String Age;
    private String visaType;
}
