package br.com.fiap.fiapautomotors.core.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Compra {

    private String id;

    private Cliente cliente;

    private Veiculo veiculo;

    private LocalDateTime dataHoraCompra;

    private BigDecimal precoPago;

    public Compra(String id, Cliente cliente, Veiculo veiculo, LocalDateTime dataHoraCompra, BigDecimal precoPago) {
        this.id = id;
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataHoraCompra = dataHoraCompra;
        this.precoPago = precoPago;
    }

    public String getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public LocalDateTime getDataHoraCompra() {
        return dataHoraCompra;
    }

    public BigDecimal getPrecoPago() {
        return precoPago;
    }
}
