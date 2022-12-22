package med.voll.api.model.mapper;

import med.voll.api.model.dto.DoctorDto;
import med.voll.api.model.entity.Doctor;


public interface DoctorMapper {

    Doctor toEntity (DoctorDto doctorDto);
}
