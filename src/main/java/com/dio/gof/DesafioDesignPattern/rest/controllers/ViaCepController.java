package com.dio.gof.DesafioDesignPattern.rest.controllers;

import com.dio.gof.DesafioDesignPattern.domain.entities.Address;
import com.dio.gof.DesafioDesignPattern.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/cep")
public class ViaCepController {

    private final ViaCepService viaCepService;

    @Autowired
    public ViaCepController(ViaCepService viaCepService) {
        this.viaCepService = viaCepService;
    }

    @GetMapping("/{cep}")
    public Address getCep(@PathVariable("cep") String cep) {
        return this.viaCepService.consultaCep(cep);
    }
}
