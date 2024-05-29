package com.teste.venda.services;

import com.teste.venda.entities.Venda;
import com.teste.venda.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaService {

    @Autowired
    private VendaRepository repository;

    public List<Venda> findAll(){
        return repository.findAll();
    }

    public Venda insert(Venda obj){
        return repository.save(obj);
    }
}
