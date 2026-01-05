package com.jvs0n.apartmentmanagerbackend.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.time.ZonedDateTime;

@Getter
@Setter
@Entity
@Builder
@Table(name = "resident")
@NoArgsConstructor
@AllArgsConstructor
public class Resident {
    @Id
    @GeneratedValue
    @Column(name = "idresident", nullable = false)
    private long id;

    @Size(max = 200)
    @NotNull
    @Column(name = "firstname", nullable = false, length = 200)
    private String firstname;

    @Size(max = 200)
    @NotNull
    @Column(name = "lastname", nullable = false, length = 200)
    private String lastname;

    @NotNull
    @PastOrPresent
    @Column(name = "birthday", nullable = false)
    private ZonedDateTime birthday;

    @Size(max = 34)
    @NotNull
    @Column(name = "iban", nullable = false, length = 34, unique = true)
    private String iban;

    @Size(max = 255)
    @NotNull
    @Column(name = "telnr", nullable = false)
    private String telnr;

    @Email
    @Size(max = 50)
    @NotNull
    @Column(name = "email", nullable = false, length = 50)
    private String email;


}