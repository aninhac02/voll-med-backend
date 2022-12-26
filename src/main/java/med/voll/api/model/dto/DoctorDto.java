package med.voll.api.model.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import med.voll.api.model.entity.Address;

@Getter
@Setter
public class DoctorDto {

    public Long id;
    @NotBlank
    public String name;
    @NotBlank
    @Email
    public String email;
    @NotBlank
    @Pattern(regexp = "\\d{4,6}")
    public String crm;
    @NotNull
    public String speciality;
    @NotNull
    @Valid
    public Address address;
}
