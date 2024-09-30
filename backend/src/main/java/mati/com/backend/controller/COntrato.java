package mati.com.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@Validated
@RestController
@CrossOrigin("http://localhost:4200/contrato")
@RequestMapping("/contrato")
public class COntrato {
    
}
