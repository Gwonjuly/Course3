package com.example.simpleboard.crud;

public interface Converter<DTO, ENTITY> {

    DTO toDto(ENTITY entity);
    ENTITY toEtity(DTO dto);
}
