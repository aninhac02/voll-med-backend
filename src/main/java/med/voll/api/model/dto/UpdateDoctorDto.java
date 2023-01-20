package med.voll.api.model.dto;


import lombok.Getter;
import lombok.Setter;
import med.voll.api.model.entity.Address;

@Getter
@Setter
public class UpdateDoctorDto {

    public Long id;

    public String name;

    public String email;

    public String telephone;

    public String crm;

    public String speciality;

    public Address address;

    private boolean active;

}
