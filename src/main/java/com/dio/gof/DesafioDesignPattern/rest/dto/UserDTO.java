package com.dio.gof.DesafioDesignPattern.rest.dto;

import com.dio.gof.DesafioDesignPattern.domain.entities.Address;
import com.dio.gof.DesafioDesignPattern.domain.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;

    private String name;

    private String username;

    private String password;

    private Address address;

    public static UserDTO toDTO(User user) {
        return new UserDTO(
            user.getId(),
            user.getName(),
            user.getUsername(),
            user.getPassword(),
            user.getAddress()
        );
    }

    public static User toOBJ(UserDTO dto) {
        return new User(
                dto.getId(),
                dto.getName(),
                dto.getUsername(),
                dto.getPassword(),
                dto.getAddress()
        );
    }
}
