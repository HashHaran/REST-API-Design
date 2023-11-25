package com.hashharan.rest.model;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@RequiredArgsConstructor
@Getter
@Setter
@RedisHash
public class Order extends Identifiable{
    @NonNull final ProductDTO product;
    @NonNull final UserDTO user;
    @NonNull OrderStatus orderStatus;
}
