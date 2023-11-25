package com.hashharan.rest.model;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@RequiredArgsConstructor
@Getter
@Setter
@RedisHash("Product")
public class Product extends Identifiable {
    @NonNull final ProviderDTO provider;
    @NonNull final InsuranceType type;
    @NonNull final String description;
    @NonNull final Boolean taxExempt;
}
