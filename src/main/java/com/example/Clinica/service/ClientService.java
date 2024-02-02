/*package com.example.Clinica.service;

import com.example.Clinica.client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    @Autowired
    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }
    public Map<String, Long> getCountByState() {
        List<Object[]> countByUf = clientRepository.countByUf();
        Map<String, Long> result = new HashMap<>();

        for (Object[] entry : countByUf) {
            String uf = (String) entry[0];
            Long count = (Long) entry[1];
            result.put(uf, count);
        }

        return result;
    }
}
*/