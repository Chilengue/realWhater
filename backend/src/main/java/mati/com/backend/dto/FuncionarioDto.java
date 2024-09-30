
package mati.com.backend.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioDto {

    private String nome;

    private String email;

    private String telefone;

    private String sexo;

    private String anoNascimento;

    private String funcao;

    private LocalDateTime horaDeEntrada;

    private LocalDateTime horaDeSaida;

}

/*package mati.com.backend.dto;

import java.time.LocalDateTime;

public record FuncionarioDto(
        String nome,
        String email,
        String telefone,
        String sexo,
        String anoNascimento,
        String funcao,
        LocalDateTime horaDeEntrada,
        LocalDateTime horaDeSaida) {

}
 */