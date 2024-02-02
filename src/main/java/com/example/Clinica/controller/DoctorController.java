package com.example.Clinica.controller;


import com.example.Clinica.User.Doctor;
import com.example.Clinica.User.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
@CrossOrigin(origins = "http://localhost:5173")
public class DoctorController {
    @Autowired
    private DoctorRepository doctorRepository;
    @PostMapping
    public ResponseEntity<String> createDoctor(@RequestBody Doctor doctor){
        try {
            if (doctorRepository.findByCpf(doctor.getCpf()) != null) {
                return ResponseEntity.badRequest().body("CPF já cadastrado");
            }
            doctor.setRole("ROLE_MEDICO");
            doctorRepository.save(doctor);
            return ResponseEntity.ok("Médico cadastrado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Erro ao cadastrar médico");
        }
    }

    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        return ResponseEntity.ok(doctors);
    }
}
