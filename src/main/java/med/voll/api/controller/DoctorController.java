package med.voll.api.controller;

import med.voll.api.model.dto.DoctorDto;
import med.voll.api.model.service.DoctorService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    public DoctorService doctorService;

    public void save(@RequestBody DoctorDto doctorDto) {
        doctorService.save(doctorDto);

    }
}
