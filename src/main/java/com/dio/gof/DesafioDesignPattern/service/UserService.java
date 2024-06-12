package com.dio.gof.DesafioDesignPattern.service;

import com.dio.gof.DesafioDesignPattern.domain.repository.UserRepository;
import com.dio.gof.DesafioDesignPattern.rest.dto.AddressDTO;
import com.dio.gof.DesafioDesignPattern.rest.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository repository;
    private final AddressService service;

    @Autowired
    public UserService(UserRepository repository, AddressService service) {
        this.repository = repository;
        this.service = service;
    }

    public List<UserDTO> findAll() {
        return this.repository.findAll()
                .stream()
                .map(UserDTO::toDTO)
                .collect(Collectors.toList());
    }

    public UserDTO save(UserDTO dto) {
        return UserDTO.toDTO(this.repository.save(UserDTO.toOBJ(dto)));
    }

    public UserDTO update(UserDTO dto) {
        this.service.update(AddressDTO.toDTO(dto.getAddress()));
        return UserDTO.toDTO(this.repository.save(UserDTO.toOBJ(dto)));
    }

    public void delete(Long id) {
        this.repository.delete(UserDTO.toOBJ(this.findById(id)));
    }

    public UserDTO findById(Long id) {
        return UserDTO.toDTO(
                this.repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"))
        );
    }
}
