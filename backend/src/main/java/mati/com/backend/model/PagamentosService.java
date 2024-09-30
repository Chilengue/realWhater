package mati.com.backend.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mati.com.backend.service.PagamentoRelatorioService;

@RestController
@RequestMapping
@Controller
public class PagamentosService {
    
    @Autowired
    private  PagamentoRelatorioService pagamentosService;

    

    // @GetMapping()
    // public ResponseEntity <PagamentosModel> findAll(){
    //     return pagamentosService.equals(pagamentosService);
    // }
}
