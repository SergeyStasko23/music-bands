package ru.stacy.business.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.stacy.web.dto.AlbumDTO;

public interface AlbumService {
    Page<AlbumDTO> findAllByBandId(Long id, Pageable pageable);
}
