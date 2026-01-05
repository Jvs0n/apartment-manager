package com.jvs0n.hestia.domain;

import com.jvs0n.hestia.valueobjects.SharedspaceHasResidentId;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "sharedspace_has_resident")
public class SharedspaceHasResident {
    @EmbeddedId
    private SharedspaceHasResidentId id;

    @MapsId("id")
    @JoinColumns({
            @JoinColumn(name = "sharedspace_idsharedspace",
                    referencedColumnName = "idsharedspace",
                    nullable = false),
            @JoinColumn(name = "sharedspace_building_idbuilding",
                    referencedColumnName = "building_idbuilding",
                    nullable = false)})
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Sharedspace sharedspace;

    @MapsId("residentIdresident")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "resident_idresident", nullable = false)
    private Resident residentIdresident;

    @NotNull
    @Column(name = "hourlyrate", nullable = false)
    private BigDecimal hourlyrate;

    @NotNull
    @Column(name = "starttime", nullable = false)
    private Instant starttime;

    @NotNull
    @Column(name = "endtime", nullable = false)
    private Instant endtime;


}