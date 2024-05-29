package com.teste.venda.dtos;

public class VendaDTO {
    private String nome;
    private Double totalVendas;
    private Double mediaVendasDiaria;

    public VendaDTO(){
    }

    public VendaDTO(String nome, Double totalVendas, Double mediaVendasDiaria) {
        this.nome = nome;
        this.totalVendas = totalVendas;
        this.mediaVendasDiaria = mediaVendasDiaria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getTotalVendas() {
        return totalVendas;
    }

    public void setTotalVendas(Double totalVendas) {
        this.totalVendas = totalVendas;
    }

    public Double getMediaVendasDiaria() {
        return mediaVendasDiaria;
    }

    public void setMediaVendasDiaria(Double mediaVendasDiaria) {
        this.mediaVendasDiaria = mediaVendasDiaria;
    }
}
