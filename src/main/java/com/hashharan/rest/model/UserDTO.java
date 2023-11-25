package com.hashharan.rest.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    private Double id;
    private Integer version;
    String firstName;
    String lastName;
}
