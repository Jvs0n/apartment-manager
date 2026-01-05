package com.jvs0n.hestia.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@Table(name = "building")
@NoArgsConstructor
@AllArgsConstructor
public class Building {
    @Id
    @GeneratedValue
    @Column(name = "idbuilding", nullable = false)
    private long id;

    @Size(max = 45)
    @NotNull
    @Column(name = "buildingnr", nullable = false, length = 45)
    private String buildingnr;

    @Size(max = 200)
    @NotNull
    @Column(name = "streetname", nullable = false, length = 200)
    private String streetname;

    @NotNull
    @Column(name = "streetnr", nullable = false)
    private Integer streetnr;

    @NotNull
    @Column(name = "postalcode", nullable = false)
    private Integer postalcode;

    @Size(max = 200)
    @NotNull
    @Column(name = "city", nullable = false, length = 200)
    private String city;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "manager_idmanager", nullable = false)
    private Manager manager;

    @Builder.Default
    @Column(name = "maxapartmentsowned")
    private Integer maxapartmentsowned = 1;


}