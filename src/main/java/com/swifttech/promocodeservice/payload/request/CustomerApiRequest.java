package com.swifttech.promocodeservice.payload.request;

import com.swifttech.promocodeservice.enums.KycStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerApiRequest {
    List<String> customerIdsList;

}
