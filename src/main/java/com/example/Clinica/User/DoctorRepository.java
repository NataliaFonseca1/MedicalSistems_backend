package com.example.Clinica.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Doctor findByCpf(String cpf);
    @Query("SELECT d FROM Doctor d WHERE d.name = :name")
    Doctor findByName(String name);
}
