package com.jvs0n.apartmentmanagerbackend.persistence;

import com.jvs0n.apartmentmanagerbackend.domain.Resident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResidentRepository extends JpaRepository<Resident, Long> {

}