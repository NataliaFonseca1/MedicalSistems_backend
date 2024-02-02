package com.example.Clinica.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NurseRepository extends JpaRepository<Nurse, Long> {
    Nurse findByCpf(String cpf);
    @Query("SELECT d FROM Nurse d WHERE d.name = :name")
    Nurse findByName(String name);
}
