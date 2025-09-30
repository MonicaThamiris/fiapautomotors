package br.com.fiap.fiapautomotors.core.domain;

import br.com.fiap.fiapautomotors.core.enums.StatusVeiculo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Veiculo {

    private String id;

    private String marca;

    private String modelo;

    private String ano;

    private String cor;

    private BigDecimal preco;

    private StatusVeiculo status;

    private LocalDateTime dataHoraCompra;

    private LocalDateTime dataHoraCriacao;

    private LocalDateTime dataHoraAtualizacao;

    private String idCompra;

    public Veiculo(String marca, String modelo, String ano, String cor, BigDecimal preco) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.preco = preco;
    }

    public Veiculo(String id, String marca, String modelo, String ano, String cor, BigDecimal preco, StatusVeiculo status, LocalDateTime dataHoraCriacao, LocalDateTime dataHoraAtualizacao) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.preco = preco;
        this.status = status;
        this.dataHoraCriacao = dataHoraCriacao;
        this.dataHoraAtualizacao = dataHoraAtualizacao;
    }

    public Veiculo(String id, StatusVeiculo status, LocalDateTime dataHoraCompra, BigDecimal preco, String idCompra) {
        this.id = id;
        this.status = status;
        this.dataHoraCompra = dataHoraCompra;
        this.preco = preco;
        this.idCompra = idCompra;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public StatusVeiculo getStatus() {
        return status;
    }

    public void setStatus(StatusVeiculo status) {
        this.status = status;
    }

    public LocalDateTime getDataHoraCompra() {
        return dataHoraCompra;
    }

    public void setDataHoraCompra(LocalDateTime dataHoraCompra) {
        this.dataHoraCompra = dataHoraCompra;
    }

    public String getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(String idCompra) {
        this.idCompra = idCompra;
    }

    public LocalDateTime getDataHoraCriacao() {
        return dataHoraCriacao;
    }

    public void setDataHoraCriacao(LocalDateTime dataHoraCriacao) {
        this.dataHoraCriacao = dataHoraCriacao;
    }

    public LocalDateTime getDataHoraAtualizacao() {
        return dataHoraAtualizacao;
    }

    public void setDataHoraAtualizacao(LocalDateTime dataHoraAtualizacao) {
        this.dataHoraAtualizacao = dataHoraAtualizacao;
    }
}
