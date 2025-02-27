package com.sandhya.spring_security.domain.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SkuCreateRequest {

    private String name;
    private String itemId;
    private String lastModifiedUser;

}
