package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.model.dto.DoctorDto;
import med.voll.api.model.dto.UpdateDoctorDto;
import med.voll.api.model.entity.Doctor;
import med.voll.api.model.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

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

    @GetMapping("/{id}")
    public DoctorDto findById(@PathVariable Long id){
        return doctorService.findById(id);
    }

    @GetMapping
    public List<DoctorDto> findAll() {
        return doctorService.findAll();

    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody UpdateDoctorDto updateDoctorDto) {
        return doctorService.update(id, updateDoctorDto);
    }


}
