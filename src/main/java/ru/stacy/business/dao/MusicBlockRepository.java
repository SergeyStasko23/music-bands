package ru.stacy.business.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.stacy.business.entity.MusicBlock;

@Repository
public interface MusicBlockRepository extends JpaRepository<MusicBlock, Long> {
    MusicBlock findByName(String name);
}
