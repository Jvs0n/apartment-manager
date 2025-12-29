package com.jvs0n.apartmentmanagerbackend;

import org.springframework.boot.SpringApplication;
import org.testcontainers.utility.TestcontainersConfiguration;

public class TestApartmentManagerBackendApplication {

    public static void main(String[] args) {
        SpringApplication.from(ApartmentManagerBackendApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
