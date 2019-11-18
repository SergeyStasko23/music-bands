package ru.stacy.business.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.stacy.business.dao.BandRepository;
import ru.stacy.business.entity.Band;
import ru.stacy.business.service.BandService;
import ru.stacy.util.exception.ResourceNotFoundException;
import ru.stacy.web.dto.BandDTO;
import ru.stacy.web.dto.mapper.BandMapper;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class BandServiceImpl implements BandService {
    private final BandRepository bandRepository;
    private final BandMapper bandMapper;

    @Override
    public List<BandDTO> findAll() {
        log.info("Find all bands");
        List<Band> bands = bandRepository.findAll();
        return bandMapper.toDTOs(bands);
    }

    @Override
    public BandDTO findById(Long id) {
        Band band = bandRepository.findById(id).orElseThrow(
                ResourceNotFoundException::new
        );
        return bandMapper.toDTO(band);
    }

    @Transactional
    @Override
    public Long save(BandDTO bandDTO) {
        Band band = bandMapper.toEntity(bandDTO);

        band.getAlbums().forEach(album -> album.setBand(band));
        band.getMusicians().forEach(musician -> musician.setBand(band));

        return bandRepository.save(band).getId();
    }

    @Transactional
    @Override
    public Long update(Long id, BandDTO bandDTO) {
        Band band = bandRepository.findById(id).orElseThrow(
                ResourceNotFoundException::new
        );
        bandMapper.updateFromDTO(bandDTO, band);

        band.getAlbums().forEach(album -> album.setBand(band));
        band.getMusicians().forEach(musician -> musician.setBand(band));

        Long result = bandRepository.save(band).getId();
        log.info("Update band (id: {})", result);
        return result;
    }

    @Transactional
    @Override
    public Boolean delete(Long id) {
        Band band = bandRepository.findById(id).orElseThrow(
                ResourceNotFoundException::new
        );
        bandRepository.delete(band);
        return !bandRepository.findById(id).isPresent();
    }
}
