package com.jvs0n.hestia.persistence;

import com.jvs0n.hestia.domain.Building;
import com.jvs0n.hestia.domain.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {
    List<Building> findByManager(Manager manager);
}