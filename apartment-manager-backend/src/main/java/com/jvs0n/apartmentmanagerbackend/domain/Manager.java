package com.jvs0n.apartmentmanagerbackend.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "manager")
public class Manager {
    @Id
    @Column(name = "idmanager", nullable = false)
    private Integer id;

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
    private LocalDate birthday;


}