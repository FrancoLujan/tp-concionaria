package com.example.pruebas.dtos.detallesDto;

import com.example.pruebas.dtos.InteresadoDTO;
import com.example.pruebas.dtos.PruebaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetalleInteresadoDTO {
    private InteresadoDTO interesado;
    private List<PruebaDTO> pruebas;
    private List<DetallePromocionDTO> promociones;
}
