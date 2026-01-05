package com.jvs0n.hestia.persistence;

import com.jvs0n.hestia.domain.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
}