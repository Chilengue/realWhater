package mati.com.backend.model;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "medidores_agua")
@Data
public class MedidoresAguaModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private LocalDateTime Data_leeitura;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private FuncionarioModell funcionarioModell;

    private LocalDateTime Periodo;
}
