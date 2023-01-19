package med.voll.api.model.service;


import med.voll.api.model.dto.PatientDto;
import med.voll.api.model.entity.Patient;
import med.voll.api.model.repository.PatientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
