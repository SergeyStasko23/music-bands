package ru.stacy.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class MusicBlockDTO extends AbstractEntityDTO {
    @JsonIgnore
    List<BandDTO> bands;
}
