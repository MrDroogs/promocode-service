package com.swifttech.promocodeservice.service.impl;

import com.swifttech.promocodeservice.core.base.Codes;
import com.swifttech.promocodeservice.core.exception.RemitException;
import com.swifttech.promocodeservice.entity.CustomerSegmentEntity;
import com.swifttech.promocodeservice.mapper.CustomerSegmentMapper;
import com.swifttech.promocodeservice.payload.request.CustomerSegmentRequest;
import com.swifttech.promocodeservice.repository.CustomerRepository;
import com.swifttech.promocodeservice.repository.PromoCodeRepository;
import com.swifttech.promocodeservice.service.CustomerSegmentService;
import com.swifttech.promocodeservice.util.DataValidation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerSegmentServiceImpl implements CustomerSegmentService {
    private static final Logger LOG = LoggerFactory.getLogger(BasicSetupServiceImpl.class);
    private final  CustomerRepository customerRepository;
    private final PromoCodeRepository promoCodeRepository;
    private final Codes codes;
    private final DataValidation dataValidation;


    @Override
    public void createCustomerSegment(CustomerSegmentRequest customerSegmentRequest) {
        CustomerSegmentEntity customerSegmentEntity = customerRepository.findByKycStatus(customerSegmentRequest.getKycStatus());
        CustomerSegmentEntity customerSegment=CustomerSegmentMapper.Instance.toEntity(customerSegmentRequest);

         customerRepository.save(customerSegment);


    }

    @Override
    public CustomerSegmentEntity updateCustomerSegment(UUID id, CustomerSegmentRequest customerSegmentRequest) {
       CustomerSegmentEntity customerSegment = customerRepository.findById(id).orElseThrow(()
               -> new RemitException(codes.pick("PRM001")));
       CustomerSegmentMapper.Instance.toRequest(customerSegment );
        return customerRepository.save(customerSegment);
    }

    @Override
    public void deleteCustomerSegment(UUID id) {
        Optional<CustomerSegmentEntity> customerSegmentId = customerRepository.findById(id);
        if (customerSegmentId.isPresent()) {
            CustomerSegmentEntity customerSegment = customerSegmentId.get();
            customerRepository.save(customerSegment);
        }
    }

}

