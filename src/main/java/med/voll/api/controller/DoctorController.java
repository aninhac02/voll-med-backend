package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.model.dto.DoctorDto;
import med.voll.api.model.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    public DoctorService doctorService;

    @PostMapping
    @Transactional
    public void save(@RequestBody @Valid DoctorDto doctorDto) {
        doctorService.save(doctorDto);

    }

    @GetMapping
    public void findById(@RequestParam Long id){
        doctorService.findById(id);
    }
}
