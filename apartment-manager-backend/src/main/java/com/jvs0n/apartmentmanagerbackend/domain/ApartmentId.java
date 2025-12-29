package com.jvs0n.apartmentmanagerbackend.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class ApartmentId implements Serializable {
    private static final long serialVersionUID = -7920164446596482148L;
    @NotNull
    @Column(name = "apartmentnr", nullable = false)
    private Integer apartmentnr;

    @Size(max = 45)
    @NotNull
    @Column(name = "buildingnr", nullable = false, length = 45)
    private String buildingnr;


}