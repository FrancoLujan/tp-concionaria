package com.example.pruebas.repositories;

import com.example.pruebas.models.Prueba;
import com.example.pruebas.models.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PruebaRepository extends JpaRepository<Prueba, Integer> {

    Prueba findByVehiculoAndFechaHoraFinIsNull(Vehiculo vehiculo);

}
