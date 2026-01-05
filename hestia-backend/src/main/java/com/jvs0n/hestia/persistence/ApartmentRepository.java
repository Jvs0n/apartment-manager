package com.jvs0n.hestia.persistence;

import com.jvs0n.hestia.domain.Apartment;
import com.jvs0n.hestia.valueobjects.ApartmentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, ApartmentId> {
}