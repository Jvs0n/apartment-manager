package com.jvs0n.apartmentmanagerbackend.valueobjects;

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
public class ApartmentHasTenantId implements Serializable {
    private static final long serialVersionUID = -4782665201185258150L;
    @NotNull
    @Column(name = "resident_idresident_tenant", nullable = false)
    private Integer residentIdresidentTenant;

    @NotNull
    @Column(name = "renthistory_idrenthistory", nullable = false)
    private Integer renthistoryIdrenthistory;


}