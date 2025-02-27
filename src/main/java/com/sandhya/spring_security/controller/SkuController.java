package com.sandhya.spring_security.controller;

import com.sandhya.spring_security.domain.entity.Sku;
import com.sandhya.spring_security.domain.request.SkuCreateRequest;
import com.sandhya.spring_security.mapper.SkuMapper;
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

@RestController
@RequestMapping(value = "/skus")
public class SkuController {

    @Autowired
    private ISkuService iSkuService;

    @Autowired
    private SkuMapper skuMapper;

    private static final String WELCOME_STRING = "Welcome Developers";

    @RequestMapping(method = RequestMethod.GET, path = "/welcome")
    public ResponseEntity<String> getWelcomeMessage() {
        return new ResponseEntity<>(WELCOME_STRING, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public ResponseEntity<Sku> getSkuById(@PathVariable String id) {
        return new ResponseEntity<>(iSkuService.getSkuById(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)

    public ResponseEntity<Sku> createSku(@RequestBody SkuCreateRequest skuCreateRequest) {
        Sku sku = skuMapper.mapSkuCreateRequest(skuCreateRequest);
        return new ResponseEntity<>(iSkuService.createSku(sku), HttpStatus.CREATED);
    }

}
