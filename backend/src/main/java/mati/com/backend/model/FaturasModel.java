package mati.com.backend.model;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "faturas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FaturasModel implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ContratoID")
    private ContratoModel contrac;

    //consumidor
    @OneToMany (mappedBy = "faturas", fetch = FetchType.LAZY, cascade = {CascadeType.DETACH})
    private Set<ConsumidorModel> consumidor;
    private ConsumidorModel consumidorModel;

    private Long leitural__anterior;

    private Long leeitura_actual;

    private double consumo;

    private double valorPagar;
    
     private StatusContrato status;
}
