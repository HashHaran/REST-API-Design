package com.hashharan.rest.data;

import com.hashharan.rest.model.User;
import org.springframework.data.repository.ListCrudRepository;

public interface UserCrudRepository extends ListCrudRepository<User, Long> {
}
