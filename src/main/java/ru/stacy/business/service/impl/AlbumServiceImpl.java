package ru.stacy.business.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.stacy.business.dao.AlbumRepository;
import ru.stacy.business.service.AlbumService;
import ru.stacy.web.dto.AlbumDTO;
import ru.stacy.web.dto.mapper.AlbumMapper;

@Slf4j
@RequiredArgsConstructor
@Service
public class AlbumServiceImpl implements AlbumService {
    private final AlbumRepository albumRepository;
    private final AlbumMapper albumMapper;

    @Override
    public Page<AlbumDTO> findAllByBandId(Long bandId, Pageable pageable) {
        return albumRepository.findAllByBandId(bandId, pageable).map(albumMapper::toDTO);
    }
}
