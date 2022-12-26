package med.voll.api.model.entity;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address {

    @NotBlank
    public String street;
    @NotBlank
    public String district;
    @NotBlank
    @Pattern(regexp = "\\d{8}")
    public String cep;
    @NotBlank
    public String city;
    @NotBlank
    public String uf;
    public String number;
    public String complement;
}
