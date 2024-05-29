package com.teste.venda.services;

import com.teste.venda.dtos.VendaDTO;
import com.teste.venda.entities.Venda;
import com.teste.venda.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendaService {

    @Autowired
    private VendaRepository repository;

    public List<Venda> findAll(){
        return repository.findAll();
    }

    public List<VendaDTO> findByDataBetween(LocalDate startDate, LocalDate endDate){
        int qntdDias = (int) ChronoUnit.DAYS.between(startDate, endDate) + 1;
        return calcularTotalVendas(repository.findByDataBetween(startDate, endDate), qntdDias);
    }

    public Venda insert(Venda obj){
        return repository.save(obj);
    }

    public List<VendaDTO> calcularTotalVendas(List<Venda> vendas, int qntdDias){
        List<VendaDTO> totalVendas = new ArrayList<>();
        List<Integer> vendedorJaCalculado = new ArrayList<>();
        for(Venda venda : vendas){
            double somaVendasVendedorX = 0;
            if(!vendedorJaCalculado.contains(venda.getVendedorId())){
                List<Venda> vendasVendedorX = vendas.stream().filter(vendaAtual -> vendaAtual.getVendedorId() == venda.getVendedorId()).collect(Collectors.toList());

                for(Venda vendaVendedorX : vendasVendedorX){
                    somaVendasVendedorX += vendaVendedorX.getValor();
                }
                double mediaVendasDiaria = somaVendasVendedorX/qntdDias;

                DecimalFormat df = new DecimalFormat("#.##");

                mediaVendasDiaria = Double.parseDouble(String.format("%.2f", mediaVendasDiaria).replace(',', '.'));

                totalVendas.add(new VendaDTO(venda.getVendedorNome(), somaVendasVendedorX, mediaVendasDiaria));

                vendedorJaCalculado.add(venda.getVendedorId());

                vendas = vendas.stream().filter(vendaAtual -> vendaAtual.getVendedorId() != venda.getVendedorId()).collect(Collectors.toList());
            }

        }

        return totalVendas;
    }
}
