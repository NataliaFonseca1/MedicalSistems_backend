package com.example.Clinica.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NurseRepository extends JpaRepository<Nurse, Long> {
    Nurse findByCpf(String cpf);
}
