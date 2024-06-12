package com.dio.gof.DesafioDesignPattern.rest.controllers;

import com.dio.gof.DesafioDesignPattern.rest.dto.UserDTO;
import com.dio.gof.DesafioDesignPattern.service.UserService;
import feign.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/find_all")
    public List<UserDTO> findAll() {
        return this.service.findAll();
    }

    @GetMapping("/find")
    public UserDTO findById(@Param Long id) {
        return this.service.findById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO save(@RequestBody UserDTO dto) {
        return this.service.save(dto);
    }

    @PutMapping("/update")
    public UserDTO update(@RequestBody UserDTO dto) {
        return this.service.update(dto);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        this.service.delete(id);
    }
}
