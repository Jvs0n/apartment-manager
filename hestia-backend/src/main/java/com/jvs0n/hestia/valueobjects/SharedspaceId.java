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
public class SharedspaceId implements Serializable {
    private static final long serialVersionUID = 845930801752238320L;
    @NotNull
    @Column(name = "idsharedspace", nullable = false)
    private long idsharedspace;

    @NotNull
    @Column(name = "building_idbuilding", nullable = false)
    private long buildingIdbuilding;


}