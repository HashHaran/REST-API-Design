package com.hashharan.rest.model;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor
@Getter
@Setter
@RedisHash
public class Order extends Identifiable{
    @NonNull ProductDTO product;
    @NonNull UserDTO user;
    @NonNull OrderStatus orderStatus;
}
