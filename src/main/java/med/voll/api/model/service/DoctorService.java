package med.voll.api.model.service;

import lombok.NonNull;
import med.voll.api.model.Speciality;
import med.voll.api.model.dto.DoctorDto;
import med.voll.api.model.dto.UpdateDoctorDto;
import med.voll.api.model.entity.Doctor;
import med.voll.api.model.repository.DoctorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

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

    public List<DoctorDto> findAll() {
        return doctorRepository.findAll().stream().map(d -> modelMapper.map(d, DoctorDto.class)).toList();
    }

    public ResponseEntity update(Long id, UpdateDoctorDto updateDoctorDto){
        return doctorRepository.findById(id).map(doctor -> {
          if (updateDoctorDto.getName() != null) {
              doctor.setName(updateDoctorDto.getName());
          }
          if (updateDoctorDto.getEmail() != null) {
              doctor.setEmail(updateDoctorDto.getEmail());
          }
          if (updateDoctorDto.getTelephone() != null) {
              doctor.setTelephone(updateDoctorDto.getTelephone());
          }
          if (updateDoctorDto.getCrm() != null) {
              doctor.setSpeciality(Speciality.valueOf(updateDoctorDto.getSpeciality()));
          }
          if (updateDoctorDto.getAddress() != null) {
              doctor.setAddress(updateDoctorDto.getAddress());
          }

          Doctor doctorUpdated = doctorRepository.save(doctor);
          return ResponseEntity.ok().body(doctorUpdated);
        }).orElse(ResponseEntity.notFound().build());
    }

}
