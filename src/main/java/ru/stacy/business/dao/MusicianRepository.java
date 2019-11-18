package ru.stacy.business.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.stacy.business.entity.Musician;

@Repository
public interface MusicianRepository extends JpaRepository<Musician, Long> {

}
