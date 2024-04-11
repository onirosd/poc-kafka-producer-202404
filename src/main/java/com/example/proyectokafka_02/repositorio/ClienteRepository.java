package com.example.proyectokafka_02.repositorio;

import com.example.proyectokafka_02.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, String> {

    @Query("SELECT c FROM Cliente c WHERE c.fechaInsercion > :fecha")
    List<Cliente> findAllWithFechaInsercionAfter(@Param("fecha") Date fecha);
}
