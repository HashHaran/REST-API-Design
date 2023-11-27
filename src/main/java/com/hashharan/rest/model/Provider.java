package com.hashharan.rest.model;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor
@Getter
@Setter
@RedisHash("Provider")
public class Provider extends Identifiable {
    @NonNull ProviderType providerType;
    @NonNull String name;
    @NonNull String description;
    @NonNull Date dateOfInception;
}
