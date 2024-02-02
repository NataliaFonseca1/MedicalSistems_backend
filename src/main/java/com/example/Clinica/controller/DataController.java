package com.example.Clinica.controller;

import com.example.Clinica.CPFEncryption;
import com.example.Clinica.client.ClientRequestDTO;
import com.example.Clinica.client.ClientResponseDTO;
import com.example.Clinica.client.Client;
import com.example.Clinica.client.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
@CrossOrigin(origins = "http://localhost:8080/clients")
public class DataController {
    @Autowired
    private ClientRepository repository;
    @CrossOrigin(origins="*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<String> saveClient(@RequestBody ClientRequestDTO data) {
        try {
            CPFEncryption.generateKey();
            String encryptedCPF = new String(Base64.getEncoder().encode(CPFEncryption.encrypt(data.cpf())));

            if (repository.findByCPF(encryptedCPF)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("CPF já cadastrado");
            }

            data = new ClientRequestDTO(data.name(), encryptedCPF, data.birthDate(), data.weight(), data.height(), data.uf());
            Client clientData = new Client(data);
            repository.save(clientData);

            return ResponseEntity.ok("Cliente cadastrado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao cadastrar cliente");
        }
    }
    @GetMapping
    public List<ClientResponseDTO> getAll(){

      List<ClientResponseDTO> clientList = repository.findAll().stream().map(ClientResponseDTO::new).toList();
      return clientList;
    }
@PutMapping
@Transactional
    public ResponseEntity updateClient(@RequestBody ClientResponseDTO data) {
    Optional<Client> optionalClient = repository.findById(data.id());
    if (optionalClient.isPresent()) {
        Client client = optionalClient.get();
        client.setName(data.name());
        client.setCpf(data.cpf());
        client.setBirthDate(data.birthDate());
        client.setWeight(data.weight());
        client.setHeight(data.height());
        client.setUf(data.uf());
        repository.save(client);
        return ResponseEntity.ok(new ClientResponseDTO(client));
    } else {
        throw new EntityNotFoundException();
    }
}
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        Optional<Client> optionalClient = repository.findById(id);
        if (optionalClient.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            throw new EntityNotFoundException();
        }
    }

}
