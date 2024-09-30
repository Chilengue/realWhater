package mati.com.backend.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pagamentos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagamentosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    
    @OneToMany (mappedBy = "pagamentos", fetch = FetchType.LAZY, cascade = {CascadeType.DETACH})
    private Set<ConsumidorModel> consumidor;
    private ConsumidorModel consumidorModel;
    
    private double valorComMulta;
    
    private boolean multaAplicada;
    

    private LocalDateTime dataPagamentos;

    private double valorPagamento;

    private double consumo;

    public double calcularValorPagamento() {
        double valorMinimo = 250.0;
        double tarifaPorMetroCubico = 70.0;

        if (consumo < 5) {
            return valorMinimo;
        } else {
            return consumo * tarifaPorMetroCubico;
        }
    }

    public String formatarValorPagamento() {
        return String.format("Valor a pagar: %.2f MT", valorPagamento);
    }
}
