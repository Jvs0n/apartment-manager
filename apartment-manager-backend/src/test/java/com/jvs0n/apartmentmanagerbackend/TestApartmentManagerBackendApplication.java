package com.jvs0n.apartmentmanagerbackend;

import com.github.dockerjava.api.model.ExposedPort;
import com.github.dockerjava.api.model.HostConfig;
import com.github.dockerjava.api.model.PortBinding;
import com.github.dockerjava.api.model.Ports;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.testcontainers.containers.PostgreSQLContainer;

import javax.swing.*;

@Configuration
public class TestApartmentManagerBackendApplication {
    @Bean
    @ServiceConnection
    PostgreSQLContainer<?> postgreSQLContainer() {
        final int containerPort = 5432;

        PortBinding portBinding = new PortBinding(Ports.Binding.bindPort(25432), new ExposedPort(containerPort));

        return new PostgreSQLContainer<>("postgres:18.0-alpine")
                .withCreateContainerCmdModifier(cmd -> {
                    cmd.withName("pg_readit");
                    cmd.withHostConfig(new HostConfig().withPortBindings(portBinding));
                })
                .withDatabaseName("testApartmentManager")
                .withUsername("user")
                .withPassword("password")
                .withReuse(true);

    }
    public static void  main(String[] args) {
        SpringApplication.from(ApartmentManagerBackendApplication::main)
                .with(TestApartmentManagerBackendApplication.class)
                .run(args);
    }
}
