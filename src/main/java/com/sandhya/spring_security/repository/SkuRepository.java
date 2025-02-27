package com.sandhya.spring_security.repository;

import com.sandhya.spring_security.domain.entity.Sku;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SkuRepository extends JpaRepository<Sku, UUID> {

}
