package mati.com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;

import mati.com.backend.model.ConsumidorModel;
import mati.com.backend.dto.*;


@Repository
public interface ConsumidorRepository  extends JpaRepository<ConsumidorModel, UUID>{
    List<ConsumidorModel> findAll();
    ConsumidorModel save (ConsumidorDTO cosumidroDto);
    List<ConsumidorModel> findByName(String name);

    // @Query("SELECT s FROM SequenciaCliente s WHERE s.ano = :ano AND s.tipoContrato = :tipoContrato")
    // Sequenci findByAnoAndTipoContrato(@Param("ano") int ano, @Param("tipoContrato") String tipoContrato);

    // @Modifying
    // @Query("UPDATE SequenciaCliente s SET s.sequencia = :sequencia WHERE s.ano = :ano AND s.tipoContrato = :tipoContrato")
    // void atualizarSequencia(@Param("ano") int ano, @Param("tipoContrato") String tipoContrato, @Param("sequencia") int sequencia);

}
