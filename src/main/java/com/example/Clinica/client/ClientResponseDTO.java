package com.example.Clinica.client;

import java.time.LocalDate;

public record ClientResponseDTO (Long id, String name, String cpf, LocalDate birthDate, Double weight, Double height, String uf){
public ClientResponseDTO(Client client){
    this(client.getId(), client.getName(), client.getCpf(), client.getBirthDate(), client.getWeight(), client.getHeight(), client.getUf());
}
}

