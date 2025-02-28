package com.sandhya.spring_security.controller;

import com.sandhya.spring_security.domain.entity.Item;
import com.sandhya.spring_security.domain.entity.Sku;
import com.sandhya.spring_security.domain.request.SkuCreateRequest;
import com.sandhya.spring_security.mapper.SkuMapper;
import com.sandhya.spring_security.service.interfaces.IItemService;
import com.sandhya.spring_security.service.interfaces.ISkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/items")
public class ItemController {

    @Autowired
    private IItemService iItemService;

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    @PreAuthorize(value = "hasAuthority('ROLE_USER', 'ROLE_ADMIN')")
    public ResponseEntity<Item> getItemById(@PathVariable String id) {
        return new ResponseEntity<>(iItemService.getItemById(id), HttpStatus.OK);
    }
}
