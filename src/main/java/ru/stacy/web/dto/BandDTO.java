package ru.stacy.web.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class BandDTO extends AbstractEntityDTO {
    String genre;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate createdDate;

    List<AlbumDTO> albums;
    List<MusicianDTO> musicians;

    MusicBlockDTO musicBlock;
}
