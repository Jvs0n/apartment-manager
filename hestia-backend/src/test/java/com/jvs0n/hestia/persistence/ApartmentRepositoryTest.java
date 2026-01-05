package com.jvs0n.hestia.persistence;

import com.jvs0n.hestia.TestcontainersConfiguration;
import com.jvs0n.hestia.domain.Apartment;
import com.jvs0n.hestia.domain.Building;
import com.jvs0n.hestia.domain.Manager;
import com.jvs0n.hestia.valueobjects.ApartmentId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Import(TestcontainersConfiguration.class)
class ApartmentRepositoryTest {
    @Autowired
    private BuildingRepository buildingRepository;
    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private ApartmentRepository apartmentRepository;

    private Building building;
    private Manager manager;
    private Apartment apartment;
    private ApartmentId apartmentId;
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
        buildingRepository.save(building);
        apartmentId = new ApartmentId();
        apartmentId.setApartmentnr(101L);
        apartmentId.setBuildingnr(building.getBuildingnr());

        apartment = Apartment.builder()
                .id(apartmentId)
                .building(building)
                .livingspace(BigDecimal.valueOf(100))
                .build();


    }

    @Test
    void createAndRead() {
        apartmentRepository.save(apartment);
        Optional<Apartment> retrieved = apartmentRepository.findById(apartmentId);

        assertTrue(retrieved.isPresent());
    }
}
