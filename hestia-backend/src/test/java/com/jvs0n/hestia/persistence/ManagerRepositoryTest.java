package com.jvs0n.hestia.persistence;

import com.jvs0n.hestia.TestcontainersConfiguration;
import com.jvs0n.hestia.domain.Manager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.time.ZonedDateTime;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Import(TestcontainersConfiguration.class)
class ManagerRepositoryTest {
    private Manager manager;
    @Autowired
    private ManagerRepository managerRepository;

    @BeforeEach
    void setUp() {
        //ARRANGE
        manager = Manager.builder()
                .birthday(ZonedDateTime.now())
                .firstname("John")
                .lastname("Ottoya")
                .build();
    }

    @Test
    void canCreateAndRead() {
        //ACT
        Manager saved = managerRepository.save(manager);
        Optional<Manager> retrieved = managerRepository.findById(saved.getId());

        //ASSERT
        assertTrue(retrieved.isPresent());
        assertThat(retrieved.get().getFirstname()).isEqualTo("John");
    }
    
    
}