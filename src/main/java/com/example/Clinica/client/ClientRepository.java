package com.example.Clinica.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client,Long> {
    @Query("SELECT COUNT(c) > 0 FROM clients c WHERE c.cpf = :cpf")
    boolean findByCPF(@Param("cpf") String cpf);
    @Query("SELECT c.uf, COUNT(c) FROM clients c GROUP BY c.uf")
    List<Object[]> countByUf();
}


