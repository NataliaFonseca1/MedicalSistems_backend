package com.example.Clinica.controller;


import com.example.Clinica.User.Nurse;
import com.example.Clinica.User.NurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nurses")
@CrossOrigin(origins = "http://localhost:5173")
public class NurseController {

    @Autowired
    private NurseRepository nurseRepository;
    @PostMapping
    public ResponseEntity<String> createNurse(@RequestBody Nurse nurse){
        try {
            if (nurseRepository.findByCpf(nurse.getCpf()) != null) {
                return ResponseEntity.badRequest().body("CPF já cadastrado");
            }
            nurse.setRole("ROLE_NURSE");
            nurseRepository.save(nurse);
            return ResponseEntity.ok("Enfermeiro cadastrado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Erro ao cadastrar médico");
        }
    }
    @GetMapping
    public ResponseEntity<List<Nurse>> getAllNurse() {
        List<Nurse> nurse = nurseRepository.findAll();
        return ResponseEntity.ok(nurse);
    }

}