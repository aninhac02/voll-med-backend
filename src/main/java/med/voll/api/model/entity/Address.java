package med.voll.api.model.entity;

import jakarta.persistence.Embeddable;
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

    public String street;
    public String district;
    public String cep;
    public String city;
    public String uf;
    public String number;
    public String complement;
}
