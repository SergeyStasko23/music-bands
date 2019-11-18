package ru.stacy.web.dto.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.stacy.business.entity.Album;
import ru.stacy.web.dto.AlbumDTO;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper
public interface AlbumMapper extends AbstractMapper<AlbumDTO, Album> {
    @Mapping(ignore = true, target = "id")
    @BeanMapping(nullValuePropertyMappingStrategy = IGNORE)
    void updateFromDTO(AlbumDTO dto, @MappingTarget Album entity);

    @Override
    @Mapping(ignore = true, target = "band")
    AlbumDTO toDTO(Album entity);
}
