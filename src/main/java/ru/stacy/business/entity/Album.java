package ru.stacy.business.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "album")
public class Album extends AbstractEntity {
    @Column(name = "created_date")
    private LocalDate createdDate;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "band_id")
    private Band band;
}
