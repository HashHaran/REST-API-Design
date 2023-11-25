package com.hashharan.rest.model;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@RequiredArgsConstructor
@Getter
@Setter
@RedisHash("User")
public class User extends Identifiable{
    @NonNull final String firstName;
    @NonNull final String lastName;
    final String middleName;
    Date onPlatformSince;
}
