package com.example.pruebas.repositories;

import com.example.pruebas.models.Modelo;
import org.springframework.data.repository.CrudRepository;

public interface ModeloRepository extends CrudRepository<Modelo, Integer> {
}