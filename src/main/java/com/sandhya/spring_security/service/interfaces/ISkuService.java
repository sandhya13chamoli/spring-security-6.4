package com.sandhya.spring_security.service.interfaces;

import com.sandhya.spring_security.domain.entity.Sku;

public interface ISkuService {
    Sku getSkuById(String id);

    Sku createSku(Sku sku);
}
