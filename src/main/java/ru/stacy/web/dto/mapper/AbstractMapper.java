package ru.stacy.web.dto.mapper;

import java.util.List;

public interface AbstractMapper<DTO, E> {
    DTO toDTO(E entity);
    List<DTO> toDTOs(List<E> entities);

    E toEntity(DTO dto);
    List<E> toEntities(List<DTO> dtos);
}
