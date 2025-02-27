package com.sandhya.spring_security.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "item")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {

    @Id
    @GeneratedValue
    private UUID id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    private List<Sku> skus;

    private String itemName;

    private Date createdDateTime;

    private Date lastModifiedDateTime;

    private String lastModifiedUser;

}
