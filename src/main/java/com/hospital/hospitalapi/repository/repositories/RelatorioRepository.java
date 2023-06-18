package com.hospital.hospitalapi.repository.repositories;
import com.hospital.hospitalapi.domain.entities.Relatorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelatorioRepository extends JpaRepository<Relatorio, Long> { }
