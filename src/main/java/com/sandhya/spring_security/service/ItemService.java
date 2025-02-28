package com.sandhya.spring_security.service;

import com.sandhya.spring_security.domain.entity.Item;
import com.sandhya.spring_security.repository.ItemRepository;

import com.sandhya.spring_security.service.interfaces.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ItemService implements IItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item getItemById(String id) {
        return itemRepository.findById(UUID.fromString(id)).get();
    }

}
