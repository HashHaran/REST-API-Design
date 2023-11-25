package com.hashharan.rest.data;

import com.hashharan.rest.model.User;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface UserPagingAndSortingInterface extends ListPagingAndSortingRepository<User, Long> {
}
