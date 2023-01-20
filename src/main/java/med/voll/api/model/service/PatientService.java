package med.voll.api.model.service;


import med.voll.api.model.dto.PatientDto;
import med.voll.api.model.dto.UpdatePatientDto;
import med.voll.api.model.entity.Patient;
import med.voll.api.model.repository.PatientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    public PatientRepository patientRepository;

    @Autowired
    public ModelMapper modelMapper;


    public void save(PatientDto patientDto) {
        patientRepository.save(modelMapper.map(patientDto, Patient.class));
    }

    public PatientDto findById(Long id) {
        return modelMapper.map(patientRepository.findById(id), PatientDto.class);

    }

    public List<PatientDto> findAll() {
        return patientRepository.findAll().stream().map(p -> modelMapper.map(p, PatientDto.class)).toList();
    }

    public ResponseEntity update(Long id, UpdatePatientDto updatePatientDto) {
        return patientRepository.findById(id).map(patient -> {
            patient.setName(updatePatientDto.getName() != null ? updatePatientDto.getName() : patient.getName());
            patient.setEmail(updatePatientDto.getEmail() != null ? updatePatientDto.getEmail() : patient.getEmail());
            patient.setCpf(updatePatientDto.getCpf() != null ? updatePatientDto.getCpf() : patient.getCpf());
            patient.setTelephone(updatePatientDto.getTelephone() != null ? updatePatientDto.getTelephone() : patient.getTelephone());
            patient.setAddress(updatePatientDto.getAddress() != null ? updatePatientDto.getAddress() : patient.getAddress());

            Patient patientUpdated = patientRepository.save(patient);
            return ResponseEntity.ok().body(patientUpdated);
        }).orElse(ResponseEntity.notFound().build());

    }

    public void inactivate(Long id){
        patientRepository.findById(id).map(patient -> {
            patient.setActive(false);
            return null;
        });
    }
}
