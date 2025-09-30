package br.com.fiap.fiapautomotors.adapters.in.controller.response;

import br.com.fiap.fiapautomotors.core.enums.StatusVeiculo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class CompraResponse {

    private String id;

    private String clienteId;

    private String veiculoId;

    private LocalDateTime dataHoraCompra;

    private BigDecimal precoPago;

    public String getId() {
        return id;
    }

    public LocalDateTime getDataHoraCompra() {
        return dataHoraCompra;
    }

    public BigDecimal getPrecoPago() {
        return precoPago;
    }

    public String getVeiculoId() {
        return veiculoId;
    }

    public String getClienteId() {
        return clienteId;
    }
}
