package com.jvs0n.hestia.persistence;

import com.jvs0n.hestia.domain.Resident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResidentRepository extends JpaRepository<Resident, Long> {

}