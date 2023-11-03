package com.challenge.dtos;

import com.challenge.Repository;
import com.challenge.models.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pageable {
    Integer page;
    Integer size;
}
