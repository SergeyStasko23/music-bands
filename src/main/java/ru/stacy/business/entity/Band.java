package ru.stacy.business.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "band")
public class Band extends AbstractEntity {
    @Column(name = "genre")
    private String genre;

    @Column(name = "created_date")
    private LocalDate createdDate;

    @OneToMany(mappedBy = "band", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, orphanRemoval = true)
    private List<Album> albums;

    @OneToMany(mappedBy = "band", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, orphanRemoval = true)
    private List<Musician> musicians;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "music_block_id")
    private MusicBlock musicBlock;
}
