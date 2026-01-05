package com.jvs0n.hestia.domain;

import com.jvs0n.hestia.valueobjects.ApartmentHasTenantId;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "apartment_has_tenant")
public class ApartmentHasTenant {
    @EmbeddedId
    private ApartmentHasTenantId id;

    @MapsId("residentIdresidentTenant")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "resident_idresident_tenant", nullable = false)
    private Resident residentIdresidentTenant;

    @MapsId("renthistoryIdrenthistory")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "renthistory_idrenthistory", nullable = false)
    private Renthistory renthistoryIdrenthistory;

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