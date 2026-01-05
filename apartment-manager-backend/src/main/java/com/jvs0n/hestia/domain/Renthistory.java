package com.jvs0n.hestia.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "renthistory")
public class Renthistory {
    @Id
    @Column(name = "idrenthistory", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "previousrent", nullable = false, precision = 10, scale = 2)
    private BigDecimal previousrent;

    @NotNull
    @Column(name = "newrent", nullable = false, precision = 10, scale = 2)
    private BigDecimal newrent;

    @NotNull
    @Column(name = "changedate", nullable = false)
    private LocalDate changedate;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "manager_idmanager_changedby", nullable = false)
    private Manager managerIdmanagerChangedby;


}