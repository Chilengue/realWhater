package mati.com.backend.controller;
   
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import mati.com.backend.dto.ConsumidorDTO;
import mati.com.backend.model.ConsumidorModel;
import mati.com.backend.repository.ConsumidorRepository;
import mati.com.backend.service.ConsumidorService;

@Controller
@Validated
@RestController
@CrossOrigin("http://localhost:4200/consumidor")
@RequestMapping("/consumidor")
public class Consumidor {

    @Autowired
    private ConsumidorService consumidorService;

    @Autowired
    private ConsumidorRepository consumidorRepository;
    

    @GetMapping
    public ResponseEntity<List<ConsumidorModel>> findAll() {
        List<ConsumidorModel> consumidor = consumidorService.findAll();
        return ResponseEntity.ok(consumidor);
    }

    // public ResponseEntity<ConsumidorModel> findByName(@RequestBody ConsumidorDTO consumidorDTO, UUID nome){
    //     ConsumidorModel Consumidor=ConsumidorService.
    // }

    @GetMapping("/{id}")
    public ResponseEntity<ConsumidorModel> findById(@PathVariable @NotNull @Positive UUID id) {
        ConsumidorModel consumidorModel = consumidorService.findById(id);
        return ResponseEntity.ok(consumidorModel);

    }

    @PostMapping
    public ResponseEntity<ConsumidorModel> save(@RequestBody ConsumidorDTO consumidorDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(consumidorService.save(consumidorDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsumidorModel> update(@PathVariable UUID id, @RequestBody @NotNull @Positive ConsumidorDTO consumidorDTO) {
        ConsumidorModel consumidorModel = consumidorService.update(id, consumidorDTO);
        return ResponseEntity.ok(consumidorModel);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        return consumidorRepository.findById(id)
        .map(recordFound->{
            consumidorRepository.deleteById(id);
            return ResponseEntity.noContent().<Void>build();
        })
        .orElse(ResponseEntity.notFound().build());
        // consumidorService.delete(id);
        // return ResponseEntity.noContent().build();
    }

}
