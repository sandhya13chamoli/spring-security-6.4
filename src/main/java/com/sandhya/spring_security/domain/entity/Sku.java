package com.sandhya.spring_security.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "sku")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Sku {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    private String name;

    private Date createdDateTime;

    private Date lastModifiedDateTime;

    private String lastModifiedUser;

}
