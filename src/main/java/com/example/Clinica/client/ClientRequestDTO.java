package com.example.Clinica.client;

import java.time.LocalDate;

public record ClientRequestDTO (String name, String cpf, LocalDate birthDate, Double weight, Double height, String uf){
}
