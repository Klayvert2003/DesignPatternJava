package com.dio.gof.DesafioDesignPattern.service;

import com.dio.gof.DesafioDesignPattern.domain.repository.AddressRepository;
import com.dio.gof.DesafioDesignPattern.rest.dto.AddressDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {
    private final AddressRepository repository;

    @Autowired
    public AddressService(AddressRepository repository) {
        this.repository = repository;
    }

    public List<AddressDTO> findAll() {
        return this.repository
                .findAll()
                .stream()
                .map(AddressDTO::toDTO)
                .collect(Collectors.toList());
    }

    public AddressDTO save(AddressDTO dto) {
        return AddressDTO.toDTO(this.repository.save(AddressDTO.toOBJ(dto)));
    }

    public AddressDTO update(AddressDTO dto) {
        return AddressDTO.toDTO(this.repository.save(AddressDTO.toOBJ(dto)));
    }

    public void delete(Long id) {
        this.repository.delete(AddressDTO.toOBJ(this.findById(id)));
    }

    public AddressDTO findById(Long id) {
        return AddressDTO.toDTO(this.repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Address not found")));
    }
}
