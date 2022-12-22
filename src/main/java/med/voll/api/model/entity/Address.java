package med.voll.api.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Address {

    public String street;
    public String district;
    public String cep;
    public String city;
    public String uf;
    public String number;
    public String complement;
}
