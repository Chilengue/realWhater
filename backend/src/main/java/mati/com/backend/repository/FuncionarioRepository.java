package mati.com.backend.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import mati.com.backend.dto.FuncionarioDto;
import mati.com.backend.model.FuncionarioModell;

public interface FuncionarioRepository extends JpaRepository <FuncionarioModell, UUID>{

    FuncionarioModell save(FuncionarioDto funcionarioDto);
    
}
