package ru.stacy.web.api;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.stacy.business.service.AlbumService;
import ru.stacy.web.dto.AlbumDTO;

import static ru.stacy.web.api.ApiController.BAND;

@RequiredArgsConstructor
@RestController
@RequestMapping(BAND)
public class AlbumController {
    private final AlbumService albumService;

    @GetMapping("/{bandId}/albums")
    public ResponseEntity<Page<AlbumDTO>> findAllByBandId(@PathVariable(name = "bandId") Long id,
                                                          @PageableDefault(size = 5, sort = "name", direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok(albumService.findAllByBandId(id, pageable));
    }
}
