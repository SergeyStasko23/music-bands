package ru.stacy.business.service;

import ru.stacy.web.dto.BandDTO;

import java.util.List;

public interface BandService {
    List<BandDTO> findAll();
    BandDTO findById(Long id);
    Long save(BandDTO bandDTO);
    Long update(Long id, BandDTO bandDTO);
    Boolean delete(Long id);
}
