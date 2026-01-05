package com.jvs0n.hestia.valueobjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class SharedspaceHasResidentId implements Serializable {
    private static final long serialVersionUID = 5737721668149876702L;
    @NotNull
    @Column(name = "sharedspace_idsharedspace", nullable = false)
    private Integer sharedspaceIdsharedspace;

    @NotNull
    @Column(name = "sharedspace_building_idbuilding", nullable = false)
    private Integer sharedspaceBuildingIdbuilding;

    @NotNull
    @Column(name = "resident_idresident", nullable = false)
    private Integer residentIdresident;


}