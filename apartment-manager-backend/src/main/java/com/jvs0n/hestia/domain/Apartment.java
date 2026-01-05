package com.jvs0n.hestia.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Builder
@Table(name = "apartment")
@NoArgsConstructor
@AllArgsConstructor
public class Apartment {
    @EmbeddedId
    private ApartmentId id;

    @MapsId("buildingnr")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "buildingnr", nullable = false, referencedColumnName = "buildingnr")
    private Building buildingnr;

    @NotNull
    @Column(name = "livingspace", nullable = false)
    private BigDecimal livingspace;


}