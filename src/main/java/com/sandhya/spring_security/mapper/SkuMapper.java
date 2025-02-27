package com.sandhya.spring_security.mapper;

import com.sandhya.spring_security.domain.entity.Item;
import com.sandhya.spring_security.domain.entity.Sku;
import com.sandhya.spring_security.domain.request.SkuCreateRequest;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class SkuMapper {

    public Sku mapSkuCreateRequest(SkuCreateRequest skuCreateRequest) {
        Item item = Item.builder().id(UUID.fromString(skuCreateRequest.getItemId())).build();
        return Sku.builder()
                .name(skuCreateRequest.getName())
                .item(item)
                .createdDateTime(new Date())
                .lastModifiedDateTime(new Date())
                .lastModifiedUser(skuCreateRequest.getLastModifiedUser())
                .build();
    }
}
