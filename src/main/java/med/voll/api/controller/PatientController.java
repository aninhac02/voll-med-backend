package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.model.dto.PatientDto;
import med.voll.api.model.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping
    public void findById(@RequestParam Long id){
        patientService.findById(id);
    }
}
