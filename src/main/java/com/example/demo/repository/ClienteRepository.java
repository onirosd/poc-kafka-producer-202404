package com.example.demo.repository;

import com.example.demo.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {
    /**
     * Encuentra todos los clientes que tienen una fecha de inserción posterior
     * a la proporcionada.
     *
     * @param fecha La fecha de inserción a comparar.
     * @return Una lista de clientes que cumplen con el criterio.
     */
    @Query("SELECT c FROM Cliente c WHERE c.fechaInsercion < :fecha")
    List<Cliente> findAllWithFechaInsercionAfter(@Param("fecha") LocalDateTime fecha);
}
