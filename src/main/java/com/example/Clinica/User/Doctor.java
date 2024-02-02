package com.example.Clinica.User;

import jakarta.persistence.*;
import lombok.*;

@Table(name="Doctor")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private String password;
    private String role;

}
