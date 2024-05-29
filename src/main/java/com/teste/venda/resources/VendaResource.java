package com.teste.venda.resources;

import com.teste.venda.entities.Venda;
import com.teste.venda.services.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/vendas")
public class VendaResource {

    @Autowired
    private VendaService service;

    @GetMapping(value = "/{startDate}/{endDate}")
    public ResponseEntity<List<Venda>> findAll(@PathVariable LocalDate startDate, @PathVariable LocalDate endDate){
        List<Venda> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Venda> insert(@RequestBody Venda obj){
        obj = service.insert(obj);

        return ResponseEntity.ok().body(obj);
    }


}
