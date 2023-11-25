package com.hashharan.rest.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ProductDTO {
    private Double id;
    private Integer version;
    InsuranceType type;
    Boolean taxExempt;
}
