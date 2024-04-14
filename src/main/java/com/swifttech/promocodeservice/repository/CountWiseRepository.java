package com.swifttech.promocodeservice.repository;

import com.swifttech.promocodeservice.entity.CountWiseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CountWiseRepository extends JpaRepository<CountWiseEntity, UUID>{

}
