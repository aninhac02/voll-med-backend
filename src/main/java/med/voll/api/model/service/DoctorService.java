package med.voll.api.model.service;

import med.voll.api.model.dto.DoctorDto;
import med.voll.api.model.entity.Doctor;
import med.voll.api.model.repository.DoctorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    @Autowired
    public DoctorRepository doctorRepository;

    @Autowired
    public ModelMapper modelMapper;

    public void save(DoctorDto doctorDto) {
       doctorRepository.save(modelMapper.map(doctorDto, Doctor.class));
    }

    public DoctorDto findById(Long id) {
        return modelMapper.map(doctorRepository.findById(id), DoctorDto.class);

    }

    public void update(){

    }

}
