package com.hospital.hospitalapi.repository.repositories;

import com.hospital.hospitalapi.domain.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
