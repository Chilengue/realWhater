
package mati.com.backend.model;

import java.util.Date;
import java.util.UUID;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;


import org.hibernate.validator.constraints.UniqueElements;

import java.io.Serializable;
import java.time.Year;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Consumidor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsumidorModel implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String ano;

    @NotNull(message = "digita numerop de telefone")
    @Size(min = 4, max = 50, message = "nome invalido")
    private String name;


    @Email(message = "exemplo@mail.com")
    @Column(length=40, nullable = false)
    @UniqueElements(message = "este email existe ")
    private String email;

    @Size(min = 3, max = 40, message = "morada invalida")
    private String address;

    @Size(min = 9, max = 20)
    private String phone;

    @Size(min = 1, max = 9)
    private Year gender;

    private String identificadorCliente;  ///campo de gerar novo indenficador

    @Enumerated(EnumType.STRING)
    private StatusContrato statusContrato;

    //contrato
    @ManyToOne(optional = true)
    @JoinColumn(name = "contrato_id", referencedColumnName = "id", nullable=true)
    private ContratoModel contratoModel;

    //faturas
    @ManyToOne(optional = true)
    @JoinColumn(name = "fatura_id", referencedColumnName = "id", nullable=true)
    private FaturasModel faturas;

    //pagamentos
    @ManyToOne(optional = true)
    @JoinColumn(name = "pagamentos", referencedColumnName = "id", nullable=true)
    private PagamentosModel pagamentos;

    @NotNull
    private Date registrationDate;

    private String generCodigoConsumidor() {
        return ano  + id  + name.substring(0, 3).toUpperCase();
    }



}
