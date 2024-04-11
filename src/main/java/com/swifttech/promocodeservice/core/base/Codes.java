package com.swifttech.promocodeservice.core.base;




import com.swifttech.promocodeservice.core.records.CodeRecord;
import org.springframework.stereotype.Component;

@FunctionalInterface
@Component
public interface Codes {

    CodeRecord pick(String code);
}
