package ru.stacy.web.dto.mapper;

import org.mapstruct.*;
import ru.stacy.business.entity.Musician;
import ru.stacy.web.dto.MusicianDTO;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(uses = {BandMapper.class})
public interface MusicianMapper extends AbstractMapper<MusicianDTO, Musician> {
    @Mapping(source = "id", target = "id", nullValueCheckStrategy  = NullValueCheckStrategy.ALWAYS)
    Musician toEntity(MusicianDTO dto);

    @Override
    @Mapping(ignore = true, target = "band")
    MusicianDTO toDTO(Musician entity);

    @Mapping(ignore = true, target = "id")
    @BeanMapping(nullValuePropertyMappingStrategy = IGNORE)
    void updateFromDTO(MusicianDTO dto, @MappingTarget Musician entity);
}
