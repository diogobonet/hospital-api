package com.hospital.hospitalapi.repository.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.hospital.hospitalapi.domain.entities.Medico;

import java.util.Optional;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    @Query("FROM Medico m WHERE m.CRM = :crm")
    Optional<Medico> ObterMedicoPorCrm(String crm);
}
