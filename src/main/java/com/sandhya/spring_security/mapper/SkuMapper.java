package com.sandhya.spring_security.mapper;

import com.sandhya.spring_security.domain.entity.Item;
import com.sandhya.spring_security.domain.entity.Sku;
import com.sandhya.spring_security.domain.request.SkuCreateRequest;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SkuMapper {

    public Sku mapSkuCreateRequest(SkuCreateRequest skuCreateRequest) {
        Item item = Item.builder().id(skuCreateRequest.getItem().getId()).build();
        Sku sku = Sku.builder()
                .name(skuCreateRequest.getName())
                .item(item)
                .createdDateTime(new Date())
                .lastModifiedDateTime(new Date())
                .lastModifiedUser(skuCreateRequest.getLastModifiedUser())
                .build();
        return sku;
    }
}
