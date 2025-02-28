package com.sandhya.spring_security.service;

import com.sandhya.spring_security.domain.entity.Sku;
import com.sandhya.spring_security.repository.SkuRepository;
import com.sandhya.spring_security.service.interfaces.ISkuService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SkuService implements ISkuService {

    @Autowired
    private SkuRepository skuRepository;

    @Override
    public Sku getSkuById(String id) {
        return skuRepository.findById(UUID.fromString(id)).get();
    }

    @Transactional
    @Override
    public Sku createSku(Sku sku) {
        Sku sku1 =  skuRepository.save(sku);
        System.out.println("sku item" + sku1.getItem().getItemName());
        return sku1;
    }

    @Override
    public List<Sku> getAllSku() {
        return skuRepository.findAll();
    }
}
