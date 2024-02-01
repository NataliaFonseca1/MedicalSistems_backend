package com.example.Clinica.controller;

import com.example.Clinica.client.ClientRequestDTO;
import com.example.Clinica.client.ClientResponseDTO;
import com.example.Clinica.client.Client;
import com.example.Clinica.client.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class DataController {
    @Autowired
    private ClientRepository repository;
    @CrossOrigin(origins="*", allowedHeaders = "*")
    @PostMapping
    public void saveClient(@RequestBody ClientRequestDTO data){
        Client clientData = new Client(data);
        repository.save(clientData);
        return;
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
