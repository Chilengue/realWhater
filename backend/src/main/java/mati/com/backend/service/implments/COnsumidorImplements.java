package mati.com.backend.service.implments;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.management.RuntimeErrorException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mati.com.backend.dto.ConsumidorDTO;
import mati.com.backend.model.ConsumidorModel;
import mati.com.backend.repository.ConsumidorRepository;
import mati.com.backend.service.ConsumidorService;

@Service
public class COnsumidorImplements implements ConsumidorService {

    @Autowired
    private ConsumidorRepository consumidorRepository;

    @Override
    public ConsumidorModel save(ConsumidorDTO consumidor) {
        ConsumidorModel consumidorModel=new ConsumidorModel();
        BeanUtils.copyProperties(consumidor, consumidorModel);
        return consumidorRepository.save(consumidorModel);
    }

    @Override
    public List<ConsumidorModel> findAll() {
        return consumidorRepository.findAll();
    }

    @Override
    public ConsumidorModel update(UUID id, ConsumidorDTO consumidorDTO) {
        Optional<ConsumidorModel> optional =consumidorRepository.findById(id);
        if (optional.isPresent()) {
            ConsumidorModel consumidorModel=optional.get();
            consumidorModel.setName(consumidorDTO.getName());
            consumidorModel.setPhone(consumidorDTO.getPhone());
            consumidorModel.setEmail(consumidorDTO.getEmail());
            // consumidorModel.setGender(consumidorDTO.getGender());
            consumidorModel.setAddress(consumidorDTO.getAddress());
            return consumidorRepository.save(consumidorModel);
        }else{
            throw new RuntimeException("consumidor nao eoncontrado iD" + id);
        }
    }

    @Override
    public ConsumidorModel findById(UUID id) {
        return consumidorRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("consumidor nao encontrado ID" +id));
    }

    @Override
    public void delete(UUID id) {
     Optional<ConsumidorModel> consumidor=consumidorRepository.findById(id);
     if (consumidor.isPresent()) {
        consumidorRepository.delete(consumidor.get());
     }  else{
        throw new RuntimeErrorException(null, "Consumidor no encontrado");
     }  
    }

    @Override
    public List<ConsumidorModel> findByName(String name) {
    return consumidorRepository.findByName(name) ;
    }

    
}
