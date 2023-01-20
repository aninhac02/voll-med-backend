package med.voll.api.model.dto;

import jakarta.persistence.Embedded;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import med.voll.api.model.entity.Address;

@Getter
@Setter
public class UpdatePatientDto {


    private Long id;
    private String name;

    private String email;

    private String cpf;

    private String telephone;
    @Embedded
    private Address address;
}
