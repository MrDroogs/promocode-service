package com.swifttech.promocodeservice.service;

import com.swifttech.promocodeservice.payload.request.AmountWiseRequest;
import com.swifttech.promocodeservice.payload.request.CountWiseRequest;


public interface AmountCountServiceImpl {
    void createAmountWise(AmountWiseRequest amountWiseRequest);

    void createCountWise(CountWiseRequest countWiseRequest);
}
