package com.example.pruebas.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Modelos")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Modelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name="DESCRIPCION")
    private String descripcion;

    // ------- Relacion: Modelo > Vehiculo -----------
    // Un modelo puede estar asociado a varios vehículos.
    @OneToMany(mappedBy = "modelo")
    private List<Vehiculo> vehiculos;

    // ------- Relacion: Modelo > Marca -----------
    // Varios modelos estan asociados con una sola marca.
    @ManyToOne
    @JoinColumn(name = "ID_MARCA", referencedColumnName = "ID")
    private Marca marca;

}
