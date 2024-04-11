package com.swifttech.promocodeservice.payload.request;

import java.io.Serializable;
import java.util.Calendar;

public record TimeFrameRequest(Calendar startDate,Calendar endDate,int applicableDays,Boolean specifiedTime,Calendar startTime,Calendar endTime) implements Serializable {
}
