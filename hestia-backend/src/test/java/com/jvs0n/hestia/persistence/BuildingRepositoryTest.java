package com.jvs0n.hestia.persistence;

import com.jvs0n.hestia.TestcontainersConfiguration;
import com.jvs0n.hestia.domain.Building;
import com.jvs0n.hestia.domain.Manager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Import(TestcontainersConfiguration.class)
class BuildingRepositoryTest {
    @Autowired
    private BuildingRepository buildingRepository;

    private Building building;
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

        building = Building.builder()
                .city("City")
                .streetname("Street")
                .streetnr(1)
                .postalcode(1)
                .buildingnr("1A")
                .manager(manager)
                .build();
    }
    @Test
    void createAndRead() {
        managerRepository.save(manager);
        Building retrieved = buildingRepository.save(building);

        assertEquals(retrieved.getId(), building.getId());
    }
}