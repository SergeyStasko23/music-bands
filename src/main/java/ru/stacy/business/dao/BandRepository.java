package ru.stacy.business.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.stacy.business.entity.Band;

@Repository
public interface BandRepository extends JpaRepository<Band, Long> {

}
