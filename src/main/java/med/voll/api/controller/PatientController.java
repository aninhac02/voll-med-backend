package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.model.dto.PatientDto;
import med.voll.api.model.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    public PatientService patientService;

    @PostMapping
    @Transactional
    public void save(@RequestBody @Valid PatientDto patientDto) {
        patientService.save(patientDto);

    }

    @GetMapping("/{id}")
    public PatientDto findById(@PathVariable Long id){

        return patientService.findById(id);
    }

    @GetMapping
    public List<PatientDto> findAll() {
        return patientService.findAll();
    }

}
