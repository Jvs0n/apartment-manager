package com.jvs0n.hestia.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.ZonedDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "manager")
public class Manager {
    @Id
    @GeneratedValue
    @Column(name = "idmanager", nullable = false)
    private Long id;

    @Size(max = 200)
    @NotNull
    @Column(name = "firstname", nullable = false, length = 200)
    private String firstname;

    @Size(max = 200)
    @NotNull
    @Column(name = "lastname", nullable = false, length = 200)
    private String lastname;

    @NotNull
    @Column(name = "birthday", nullable = false)
    private ZonedDateTime birthday;


}