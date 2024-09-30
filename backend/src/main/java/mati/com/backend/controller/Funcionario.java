package  mati.com.backend.controller;
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
import mati.com.backend.dto.FuncionarioDto;
import mati.com.backend.model.FuncionarioModell;
import mati.com.backend.repository.FuncionarioRepository;
import mati.com.backend.service.FuncionarioService;



@Validated
@Controller
@RestController
@CrossOrigin("http://localhost:4200/funcionario")
@RequestMapping("/funcionarios")
public class Funcionario {

    @Autowired
    private FuncionarioService funcionarioService;
    
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    

    @PostMapping
    public ResponseEntity<FuncionarioModell> save (@RequestBody FuncionarioDto funcionarioDto){
           return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioService.save(funcionarioDto));
    }

    
    @GetMapping
    public ResponseEntity<List<FuncionarioModell>> findAll() {
        List<FuncionarioModell> funcionarios = funcionarioService.findAll();
        return ResponseEntity.ok(funcionarios);
    }

   
    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioModell> findById(@PathVariable @NotNull @Positive UUID id) {

           return funcionarioRepository.findById(id)
           .map(recordFound -> ResponseEntity.ok().body(recordFound))
           .orElse(ResponseEntity.notFound().build());
           //novo metedo

        // FuncionarioModell funcionario = funcionarioService.findById(id);
        // return ResponseEntity.ok(funcionario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioModell> update(@PathVariable UUID id, @RequestBody @NotNull @Positive FuncionarioDto funcionarioDto) {
        FuncionarioModell updatedFuncionario = funcionarioService.update(id, funcionarioDto);
        return ResponseEntity.ok(updatedFuncionario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
     return funcionarioRepository.findById(id)
     .map(recordFound->{
        funcionarioRepository.deleteById(id);
        return ResponseEntity.noContent().<Void>build();
     })
      .orElse(ResponseEntity.notFound().build());
    }
    
}