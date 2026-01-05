package com.jvs0n.hestia.domain;

import com.jvs0n.hestia.valueobjects.SharedspaceId;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "sharedspace")
public class Sharedspace {
    @EmbeddedId
    private SharedspaceId id;

    @MapsId("buildingIdbuilding")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "building_idbuilding", nullable = false)
    private Building buildingIdbuilding;

    @NotNull
    @Column(name = "requiredspace", nullable = false)
    private BigDecimal requiredspace;

    @Size(max = 255)
    @NotNull
    @Column(name = "sharedspacedescription", nullable = false)
    private String sharedspacedescription;


}