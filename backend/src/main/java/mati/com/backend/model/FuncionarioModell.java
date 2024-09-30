package mati.com.backend.model;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;


import org.hibernate.annotations.NaturalId;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="funcionarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioModell implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    @Size(min=4, max = 80)
    private String nome;

    @Enumerated(EnumType.STRING)
    private StatusContrato statusContrato;

    @OneToOne(mappedBy = "funcionarioModell")
    private MedidoresAguaModel aguaModel;


    @NaturalId
    @Email(message = "example@mail.com")
    private String email;

    @Size(max=14, min=7)
    @Column(length = 13, nullable = false)
    @UniqueElements(message = "")
    private String telefone;

    @Size(max = 7, min=1)
    @Column(length = 7, nullable = true)
    private String sexo;

    @NotEmpty
    private String anoNascimento;

    @Size(max=20, min=4)
    @NotBlank
    @Length(min=4, max=50)
    private String funcao;

    @DateTimeFormat
    private LocalDateTime horaDeEntrada;

    private LocalDateTime horaDeSaida;

    @NotNull
    @Length
    private String status="Ativo";

    @Lob
    private byte[] foto;
}