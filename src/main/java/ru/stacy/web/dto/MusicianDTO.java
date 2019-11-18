package ru.stacy.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class MusicianDTO extends AbstractEntityDTO {
    @JsonIgnore
    BandDTO band;
}
