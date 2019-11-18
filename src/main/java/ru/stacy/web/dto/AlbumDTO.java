package ru.stacy.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class AlbumDTO extends AbstractEntityDTO {
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate createdDate;

    @JsonIgnore
    BandDTO band;
}
