package med.voll.api.model.entity;


import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class Doctor implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    public String name;
    public String email;
    public String crm;
    public String speciality;
    public Address address;
}
