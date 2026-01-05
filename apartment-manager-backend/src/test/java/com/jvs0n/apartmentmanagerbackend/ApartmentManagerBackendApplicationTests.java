package com.jvs0n.apartmentmanagerbackend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;


@SpringBootTest
@Import(TestcontainersConfiguration.class)
class ApartmentManagerBackendApplicationTests {

    @Test
    void contextLoads() {
    }
}
