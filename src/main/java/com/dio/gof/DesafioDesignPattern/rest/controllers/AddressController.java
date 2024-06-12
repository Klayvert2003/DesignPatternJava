package com.dio.gof.DesafioDesignPattern.rest.controllers;

import com.dio.gof.DesafioDesignPattern.rest.dto.AddressDTO;
import com.dio.gof.DesafioDesignPattern.service.AddressService;
import feign.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    private final AddressService service;

    @Autowired
    public AddressController(AddressService service) {
        this.service = service;
    }

    @GetMapping("/find_all")
    public List<AddressDTO> findAll() {
        return this.service.findAll();
    }

    @GetMapping("/find")
    public AddressDTO findById(@Param Long id) {
        return this.service.findById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public AddressDTO save(@RequestBody AddressDTO dto) {
        return this.service.save(dto);
    }

    @PutMapping("/update")
    public AddressDTO update(@RequestBody AddressDTO dto) {
        return this.service.update(dto);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        this.service.delete(id);
    }
}
