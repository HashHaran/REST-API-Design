package com.hashharan.rest.model;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor
@Getter
@Setter
@RedisHash("Product")
public class Product extends Identifiable {
    @NonNull ProviderDTO provider;
    @NonNull InsuranceType type;
    @NonNull String description;
    @NonNull Boolean taxExempt;
}
