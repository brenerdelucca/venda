package com.teste.venda.repositories;

import com.teste.venda.entities.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Integer> {

}
