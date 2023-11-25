package com.hashharan.rest.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

@NoArgsConstructor()
@Getter
@Setter
public class Identifiable {
    @Id private Long id;
    @Version private Integer version;
}
