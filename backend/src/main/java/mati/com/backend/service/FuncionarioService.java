package mati.com.backend.service;

import java.util.List;
import java.util.UUID;

import mati.com.backend.dto.FuncionarioDto;
import mati.com.backend.model.FuncionarioModell;
import mati.com.backend.model.StatusContrato;

public interface FuncionarioService {
    FuncionarioModell save(FuncionarioDto funcionarioDto);

    List<FuncionarioModell> findAll();

    FuncionarioModell update(UUID id, FuncionarioDto funcionarioDto);

    FuncionarioModell findById(UUID id);

    void delete(UUID id);

    public FuncionarioModell actualizarstatus(UUID id, StatusContrato contrato);
}
