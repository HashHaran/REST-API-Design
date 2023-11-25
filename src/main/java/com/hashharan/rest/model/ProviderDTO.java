package com.hashharan.rest.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProviderDTO {
    private Double id;
    private Integer version;
    private ProviderType providerType;
    private String name;
}
