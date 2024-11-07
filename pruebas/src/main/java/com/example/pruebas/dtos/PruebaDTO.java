package com.example.pruebas.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PruebaDTO {

    private int idInteresado;
    private int idVehiculo;
    private int legajoEmpleado;

}
