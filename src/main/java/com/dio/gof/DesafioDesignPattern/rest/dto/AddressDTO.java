package com.dio.gof.DesafioDesignPattern.rest.dto;

import com.dio.gof.DesafioDesignPattern.domain.entities.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
    private Long id;

    private String cep;

    private String logradouro;

    private String complemento;

    private String bairro;

    private String localidade;

    private String uf;

    private String ibge;

    private String gia;

    private String ddd;

    private String siafi;

    public static AddressDTO toDTO(Address address) {
        return new AddressDTO(
                address.getId(),
                address.getCep(),
                address.getLogradouro(),
                address.getComplemento(),
                address.getBairro(),
                address.getLocalidade(),
                address.getUf(),
                address.getIbge(),
                address.getGia(),
                address.getDdd(),
                address.getSiafi()
        );
    }

    public static Address toOBJ(AddressDTO dto) {
        return new Address(
                dto.getId(),
                dto.getCep(),
                dto.getLogradouro(),
                dto.getComplemento(),
                dto.getBairro(),
                dto.getLocalidade(),
                dto.getUf(),
                dto.getIbge(),
                dto.getGia(),
                dto.getDdd(),
                dto.getSiafi()
        );
    }
}
