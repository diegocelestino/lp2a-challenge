package com.challenge.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page {
    Integer totalPages;
    Integer actualPage;
    Integer totalElements;
    Integer size;
    List<ClientDto> clientDtoList;

    public Page(Pageable pageable, List<ClientDto> clients){
        this.totalElements = clients.size();
        this.size = pageable.size;
        this.totalPages = this.totalElements / this.size;
        this.actualPage = pageable.page;
        this.clientDtoList = getClientsDto(clients);
    }

    private List<ClientDto> getClientsDto(List<ClientDto> clients){
        int initIndex = this.actualPage * this.size;
        int finalIndex = initIndex + this.size;
        return clients.subList(initIndex, finalIndex);
    }
}
