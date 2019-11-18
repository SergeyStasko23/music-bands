package ru.stacy.web.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.stacy.business.service.BandService;
import ru.stacy.web.dto.BandDTO;

import java.util.List;

import static ru.stacy.web.api.ApiController.BAND;

@RequiredArgsConstructor
@RestController
@RequestMapping(BAND)
public class BandController {
    private final BandService bandService;

    @GetMapping
    public ResponseEntity<List<BandDTO>> findAll() {
        return ResponseEntity.ok(bandService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BandDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(bandService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Long> save(@RequestBody BandDTO bandDTO) {
        return ResponseEntity.ok(bandService.save(bandDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> update(@PathVariable Long id, @RequestBody BandDTO bandDTO) {
        return ResponseEntity.ok(bandService.update(id, bandDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return ResponseEntity.ok(bandService.delete(id));
    }
}
