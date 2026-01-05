package com.jvs0n.hestia.persistence;

import com.jvs0n.hestia.domain.Building;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingRepository extends JpaRepository<Building, Long> {
}