package com.teste.venda.repositories;

import com.teste.venda.entities.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface VendaRepository extends JpaRepository<Venda, Integer> {

    List<Venda> findByDataBetween(LocalDate startDate, LocalDate endDate);

}
