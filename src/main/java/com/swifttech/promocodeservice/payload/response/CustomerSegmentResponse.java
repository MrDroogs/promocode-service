package com.swifttech.promocodeservice.payload.response;

import com.swifttech.promocodeservice.enums.Gender;
import com.swifttech.promocodeservice.enums.KycStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class CustomerSegmentResponse {
    @Enumerated(EnumType.STRING)
    private KycStatus kycStatus;
    private Gender gender;
    private String Nationality;
    private int Age;
    private String visaType;

}
