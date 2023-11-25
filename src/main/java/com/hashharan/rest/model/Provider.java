package com.hashharan.rest.model;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@RequiredArgsConstructor
@Getter
@Setter
@RedisHash("Provider")
public class Provider extends Identifiable {
    @NonNull final ProviderType providerType;
    @NonNull final String name;
    @NonNull final String description;
    @NonNull final Date dateOfInception;
    Date onPlatformSince;
}
