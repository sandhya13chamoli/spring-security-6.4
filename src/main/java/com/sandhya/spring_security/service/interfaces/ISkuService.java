package com.sandhya.spring_security.service.interfaces;

import com.sandhya.spring_security.domain.entity.Sku;

import java.util.List;

public interface ISkuService {
    Sku getSkuById(String id);

    Sku createSku(Sku sku);

    List<Sku> getAllSku();
}
