package med.voll.api.model.service;

import med.voll.api.model.dto.DoctorDto;
import med.voll.api.model.mapper.DoctorMapper;
import med.voll.api.model.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    @Autowired
    public DoctorRepository doctorRepository;

    @Autowired
    public DoctorMapper doctorMapper;

    public void save(DoctorDto doctorDto) {
        doctorRepository.save(doctorMapper.toEntity(doctorDto));

    }

    public void findById(Long id) {
        doctorRepository.findById(id);

    }

    public void update(){

    }

}
