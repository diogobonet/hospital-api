package com.hospital.hospitalapi.repository.repositories;

import com.hospital.hospitalapi.domain.entities.Cirurgia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CirurgiaRepository extends JpaRepository<Cirurgia, Long> {
}