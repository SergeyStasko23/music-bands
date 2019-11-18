package ru.stacy.web.dto.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.stacy.business.entity.MusicBlock;
import ru.stacy.web.dto.MusicBlockDTO;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper
public interface MusicBlockMapper extends AbstractMapper<MusicBlockDTO, MusicBlock> {
    @Mapping(ignore = true, target = "id")
    @BeanMapping(nullValuePropertyMappingStrategy = IGNORE)
    void updateFromDTO(MusicBlockDTO dto, @MappingTarget MusicBlock entity);

    @Override
    @Mapping(ignore = true, target = "bands")
    MusicBlockDTO toDTO(MusicBlock entity);
}
