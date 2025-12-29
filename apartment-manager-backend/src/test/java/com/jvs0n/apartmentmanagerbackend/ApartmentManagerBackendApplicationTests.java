package com.jvs0n.apartmentmanagerbackend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.testcontainers.utility.TestcontainersConfiguration;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class ApartmentManagerBackendApplicationTests {

    @Test
    void contextLoads() {
    }

}
