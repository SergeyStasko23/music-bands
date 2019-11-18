package ru.stacy.web.dto.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.stacy.business.entity.Band;
import ru.stacy.web.dto.BandDTO;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(uses = {AlbumMapper.class, MusicianMapper.class, MusicBlockMapper.class})
public interface BandMapper extends AbstractMapper<BandDTO, Band> {
    @Mapping(ignore = true, target = "id")
    @BeanMapping(nullValuePropertyMappingStrategy = IGNORE)
    void updateFromDTO(BandDTO dto, @MappingTarget Band entity);
}
