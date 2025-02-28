package com.sandhya.spring_security.service.interfaces;

import com.sandhya.spring_security.domain.entity.Item;
import com.sandhya.spring_security.domain.entity.Sku;

import java.util.List;

public interface IItemService {
    Item getItemById(String id);

}
