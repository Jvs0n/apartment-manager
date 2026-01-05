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
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Import(TestcontainersConfiguration.class)
class BuildingRepositoryTest {

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private ManagerRepository managerRepository;

    private Building building;
    private Manager manager;

    @BeforeEach
    void setUp() {
        manager = Manager.builder()
                .birthday(ZonedDateTime.now())
                .firstname("John")
                .lastname("Ottoya")
                .build();

        managerRepository.save(manager);

        building = Building.builder()
                .city("City")
                .streetname("Street")
                .streetnr(1)
                .postalcode(1)
                .buildingnr("1A")
                .manager(manager)
                .maxapartmentsowned(5)
                .build();
    }

    @Test
    void createAndRead() {
        Building saved = buildingRepository.save(building);
        Optional<Building> retrieved = buildingRepository.findById(saved.getId());

        assertTrue(retrieved.isPresent());
        assertEquals(saved.getId(), retrieved.get().getId());
        assertEquals("City", retrieved.get().getCity());
    }

    @Test
    void updateBuilding() {
        Building saved = buildingRepository.save(building);

        // Update some fields
        saved.setCity("NewCity");
        saved.setMaxapartmentsowned(10);

        Building updated = buildingRepository.save(saved);
        Optional<Building> retrieved = buildingRepository.findById(updated.getId());

        assertTrue(retrieved.isPresent());
        assertEquals("NewCity", retrieved.get().getCity());
        assertEquals(10, retrieved.get().getMaxapartmentsowned());
    }

    @Test
    void deleteBuilding() {
        Building saved = buildingRepository.save(building);

        buildingRepository.delete(saved);

        Optional<Building> retrieved = buildingRepository.findById(saved.getId());
        assertFalse(retrieved.isPresent());
    }

    @Test
    void findAllByManager() {
        buildingRepository.save(building);

        List<Building> buildings = buildingRepository.findByManager(manager);
        assertNotNull(buildings);
        assertFalse(buildings.isEmpty());
        assertEquals(manager.getId(), buildings.getFirst().getManager().getId());
    }
}
