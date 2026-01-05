package com.jvs0n.hestia.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "apartment_has_owner")
public class ApartmentHasOwner {
    @Id
    @Column(name = "resident_idresident_owner", nullable = false)
    private long id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "resident_idresident_owner", nullable = false)
    private Resident resident;

    @NotNull
    @JoinColumns({
            @JoinColumn(name = "apartment_apartmentnr",
                    referencedColumnName = "apartmentnr",
                    nullable = false),
            @JoinColumn(name = "apartment_buildingnr",
                    referencedColumnName = "buildingnr",
                    nullable = false)})
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Apartment apartment;

    @NotNull
    @Column(name = "movein", nullable = false)
    private LocalDate movein;

    @Column(name = "moveout")
    private LocalDate moveout;


}