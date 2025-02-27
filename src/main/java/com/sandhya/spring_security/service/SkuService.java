package com.sandhya.spring_security.service;

import com.sandhya.spring_security.domain.entity.Sku;
import com.sandhya.spring_security.repository.SkuRepository;
import com.sandhya.spring_security.service.interfaces.ISkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SkuService implements ISkuService {

    @Autowired
    private SkuRepository skuRepository;

    @Override
    public Sku getSkuById(String id) {
        return skuRepository.findById(UUID.fromString(id)).get();
    }

    @Override
    public Sku createSku(Sku sku) {
        return skuRepository.save(sku);
    }
}
