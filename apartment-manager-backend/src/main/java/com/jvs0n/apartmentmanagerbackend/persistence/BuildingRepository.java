package com.jvs0n.apartmentmanagerbackend.persistence;

import com.jvs0n.apartmentmanagerbackend.domain.Building;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingRepository extends JpaRepository<Building, Long> {
}