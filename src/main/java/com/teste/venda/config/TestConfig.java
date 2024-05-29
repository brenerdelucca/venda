package com.teste.venda.config;

import com.teste.venda.entities.Venda;
import com.teste.venda.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private VendaRepository vendaRepository;

    @Override
    public void run(String... args) throws Exception {
        Venda v1 = new Venda(null, LocalDate.parse("2024-02-03"), 300.00, 1, "Jose Ribeiro");
        Venda v2 = new Venda(null, LocalDate.parse("2024-02-15"), 100.00, 1, "Jose Ribeiro");

        vendaRepository.saveAll(Arrays.asList(v1, v2));
    }
}
