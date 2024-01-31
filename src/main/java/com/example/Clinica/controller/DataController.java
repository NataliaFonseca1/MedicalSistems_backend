package com.example.Clinica.controller;

import com.example.Clinica.client.ClientRequestDTO;
import com.example.Clinica.client.ClientResponseDTO;
import com.example.Clinica.client.Client;
import com.example.Clinica.client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


}
