package mati.com.backend.service.implments;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mati.com.backend.dto.FuncionarioDto;
import mati.com.backend.model.FuncionarioModell;
import mati.com.backend.model.StatusContrato;
import mati.com.backend.repository.FuncionarioRepository;
import mati.com.backend.service.FuncionarioService;

@Service
public class FuncionarioImplements implements FuncionarioService{

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public FuncionarioModell save(FuncionarioDto funcionarioDto) {
        FuncionarioModell funcionarioModel = new FuncionarioModell();
        BeanUtils.copyProperties(funcionarioDto, funcionarioModel);
        return funcionarioRepository.save(funcionarioModel);
    }

    @Override
    public void delete(UUID id) {
        Optional<FuncionarioModell> funcionario = funcionarioRepository.findById(id);
        if (funcionario.isPresent()) {
            funcionarioRepository.delete(funcionario.get());
        } else {
            throw new RuntimeException("Funcionário não encontrado.");
        }
    }

    @Override
    public List<FuncionarioModell> findAll() {
        return funcionarioRepository.findAll();
    }

    @Override
    public FuncionarioModell findById(UUID id) {
        return funcionarioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Funcionário não encontrado com o ID: " + id));
    }

    @Override
    public FuncionarioModell update(UUID id, FuncionarioDto funcionarioDto) {
        Optional<FuncionarioModell> funcOptional = funcionarioRepository.findById(id);
        if (funcOptional.isPresent()) {
            FuncionarioModell funcionarioModell = funcOptional.get();
            // Atualizar as propriedades da entidade a partir do DTO
            funcionarioModell.setNome(funcionarioDto.getNome());
            funcionarioModell.setEmail(funcionarioDto.getEmail());
            funcionarioModell.setTelefone(funcionarioDto.getTelefone());
            funcionarioModell.setSexo(funcionarioDto.getSexo());
            funcionarioModell.setAnoNascimento(funcionarioDto.getAnoNascimento());
            return funcionarioRepository.save(funcionarioModell);
        } else {
            throw new RuntimeException("Funcionário não encontrado pelo ID: " + id);
        }
    }

    @Override
    public FuncionarioModell actualizarstatus(UUID id, StatusContrato contrato) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarstatus'");
    }

    // @Override
    // public FuncionarioModell actualizarstatus(UUID id, StatusContrato contrato) {
    //     StatusContrato contrato2=funcionarioRepository.findById(id)
    //     .orElseThrow(()-> new RuntimeException("funcionario nao econtrado"));
        
    //     throw new UnsupportedOperationException("Unimplemented method 'actualizarstatus'");
    // }
}
