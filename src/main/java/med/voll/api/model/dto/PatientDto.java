package med.voll.api.model.dto;

import jakarta.persistence.Embedded;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import med.voll.api.model.entity.Address;

@Getter
@Setter
public class PatientDto {


    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String cpf;
    @NotBlank
    private String telephone;
    @Embedded
    private Address address;

    private boolean active;
}
