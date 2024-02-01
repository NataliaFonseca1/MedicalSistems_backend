package com.example.Clinica.client;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Table(name = "clients")
@Entity(name = "clients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Client {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    @Column(unique=true)
    private String cpf;
    private LocalDate birthDate;
    private Double weight;
    private Double height;
    private String uf;

    public Client (ClientRequestDTO data){
        this.name = data.name();
        this.cpf = data.cpf();
        this.birthDate=data.birthDate();
        this.weight= data.weight();
        this.height=data.height();
        this.uf= data.uf();
    }


}
