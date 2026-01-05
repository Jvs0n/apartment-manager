package com.jvs0n.apartmentmanagerbackend.persistence;

import com.jvs0n.apartmentmanagerbackend.TestcontainersConfiguration;
import com.jvs0n.apartmentmanagerbackend.domain.Resident;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.context.annotation.Import;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Import(TestcontainersConfiguration.class)
class ResidentRepositoryTest {
    @Autowired
    private ResidentRepository residentRepository;
    private Resident r;
    @BeforeEach
    void setUp() {
        //ARRANGE
         r = Resident.builder()
                .email("John@Resident.com")
                .telnr("+43 660 000 0000")
                .firstname("John")
                .lastname("Resident")
                .iban("ATXX XXXX XXXX XXXX XXXX")
                .birthday(ZonedDateTime.now())
                .build();
    }
    @Test
    void canCreateAndRead() {
        //ACT
        Resident saved = residentRepository.save(r);
        Optional<Resident> retrieved = residentRepository.findById(saved.getId());

        //ASSERT
        assertTrue(retrieved.isPresent());
        assertThat(retrieved.get().getFirstname()).isEqualTo("John");
    }

    @Test
    void canUpdateResident() {
        //ACT
        Resident saved = residentRepository.save(r);

        saved.setFirstname("Janet");
        residentRepository.save(saved);

        Resident updated = residentRepository.findById(saved.getId()).orElseThrow();

        //ASSERT
        assertThat(updated.getFirstname()).isEqualTo("Janet");
    }

    @Test
    void canDeleteResident() {
        //ACT
        Resident saved = residentRepository.save(r);
        residentRepository.delete(saved);

        Optional<Resident> retrieved = residentRepository.findById(saved.getId());

        //ASSERT
        assertTrue(retrieved.isEmpty());
    }


}