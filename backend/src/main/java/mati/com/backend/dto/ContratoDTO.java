package mati.com.backend.dto;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mati.com.backend.model.ConsumidorModel;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContratoDTO {
   
    private ConsumidorModel consumidorModel;
    private String tipoContrato;

    private double tarifa_base;

    private double taxa_variavel;

    private LocalDateTime dataContrato; 
}

