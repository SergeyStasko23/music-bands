package ru.stacy.business.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "music_block")
public class MusicBlock extends AbstractEntity {
    @OneToMany(mappedBy = "musicBlock")
    private List<Band> bands;
}
