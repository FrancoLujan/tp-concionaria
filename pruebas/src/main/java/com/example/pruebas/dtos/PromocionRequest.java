package com.example.pruebas.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromocionRequest {
    @JsonProperty("promocion")
    private PromocionDTO promocion;

    @JsonProperty("interesados")
    private List<Integer> interesadosId;

    @JsonProperty("vehiculos")
    private List<Integer> vehiculosId;
}
