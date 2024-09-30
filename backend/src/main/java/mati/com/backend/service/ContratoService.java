package mati.com.backend.service;

import java.util.List;

import org.hibernate.validator.constraints.UUID;

import mati.com.backend.dto.*;
import mati.com.backend.model.*;


public interface ContratoService {
    ContratoModel save(ContratoDTO contraDTO);

    List<ContratoModel> findAll();

    ContratoModel update(UUID id, ContratoDTO contraDTO);

    ContratoModel findById(UUID id);

    void delete(UUID id);
}
