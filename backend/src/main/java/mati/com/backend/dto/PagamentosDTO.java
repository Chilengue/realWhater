package mati.com.backend.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mati.com.backend.model.ConsumidorModel;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagamentosDTO {

     private ConsumidorModel consumidorModel;
    
    private double valorComMulta;
    
    private boolean multaAplicada;
    

    private LocalDateTime dataPagamentos;

    private double valorPagamento;

}
