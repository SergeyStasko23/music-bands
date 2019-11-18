package ru.stacy.business.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "musician")
public class Musician extends AbstractEntity {
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "band_id")
    private Band band;
}
