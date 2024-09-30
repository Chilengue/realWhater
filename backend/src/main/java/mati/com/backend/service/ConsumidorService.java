package mati.com.backend.service;

import org.springframework.stereotype.Service;

import mati.com.backend.dto.ConsumidorDTO;
import mati.com.backend.model.ConsumidorModel;
import java.util.*;

@Service
public interface ConsumidorService {
    
    ConsumidorModel save (ConsumidorDTO consumidor);

    List<ConsumidorModel> findAll();

    ConsumidorModel update (UUID id, ConsumidorDTO consumidorDTO);
     
    ConsumidorModel findById(UUID id);

    List<ConsumidorModel> findByName(String name);


    void delete (UUID id);
}
