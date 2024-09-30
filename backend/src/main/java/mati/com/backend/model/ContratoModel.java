


package mati.com.backend.model;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.Set;
import java.io.Serializable;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "contrato")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContratoModel implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    //consumidor
    @OneToMany (mappedBy = "contratoModel", fetch = FetchType.LAZY, cascade = {CascadeType.DETACH})
    private Set<ConsumidorModel> consumidor;

    @OneToOne(mappedBy = "contrac")
    private FaturasModel faturas;

    private String tipoContrato;

    private double tarifaBase;

    private double taxaVariavel;

    private LocalDateTime dataContrato;

}
