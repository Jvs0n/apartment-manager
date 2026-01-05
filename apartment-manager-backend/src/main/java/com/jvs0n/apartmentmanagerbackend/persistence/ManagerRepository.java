package com.jvs0n.apartmentmanagerbackend.persistence;

import com.jvs0n.apartmentmanagerbackend.domain.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
}