// package mati.com.backend.service.implments;


// import java.util.List;
// import java.util.Optional;
// import java.util.UUID;

// import javax.management.RuntimeErrorException;

// import org.springframework.beans.BeanUtils;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import mati.com.backend.dto.ContratoDTO;
// import mati.com.backend.model.ContratoModel;
// import mati.com.backend.repository.ContratoRepository;
// import mati.com.backend.service.ContratoService;

// @Service
// public class ContratoImplements implements ContratoService {

//     @Autowired
//     private ContratoRepository contratoRepository;


//     @Override
//     public ContratoModel save(ContratoDTO contraDTO) {
//         ContratoModel contratoModel=new ContratoModel();
//         BeanUtils.copyProperties(contraDTO, contratoModel);
//         return contratoRepository.save(contratoModel);
//     }

//     @Override
//     public List<ContratoModel> findAll() {
//         return contratoRepository.findAll();
//     }

//     @Override
//     public ContratoModel update(UUID id, ContratoDTO contraDTO) {
//         Optional<ContratoModel> optional=contratoRepository.findById(id);
//         if (optional.isPresent()) {
//             ContratoModel contratoModel=optional.get();
//             contratoModel.setTipoContrato(contraDTO.getTipoContrato());
//             contratoModel.setTarifaBase(contraDTO.getTarifa_base());
//             contratoModel.setTaxaVariavel(contraDTO.getTarifa_base());
//             // contratoModel.setConsumidor(contraDTO.getConsumidorModel());
//             contratoModel.setDataContrato(contraDTO.getDataContrato());
//             return contratoRepository.save(contratoModel);
//         }else{
//             throw new RuntimeException("contrato nao encontrado ID"+ id);
//         }
//     }

//     @Override
//     public ContratoModel findById(UUID id) {
//         return contratoRepository.findById(id)
//         .orElseThrow(()-> new RuntimeException("consumidor nao encontrado ID" +id));
//     }

//     @Override
//     public void delete(UUID id) {
//     Optional<ContratoModel> coOptional= contratoRepository.findById(id);
//     if(coOptional.isPresent()){
//         contratoRepository.delete(coOptional.get());
//     }else{
//         throw new RuntimeErrorException("contrato nao encontrado");
//     }
//     }

    
// }
