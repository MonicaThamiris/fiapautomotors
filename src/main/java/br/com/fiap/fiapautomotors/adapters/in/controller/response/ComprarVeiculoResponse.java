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
public class ComprarVeiculoResponse {

    private String compraId;

    private StatusVeiculo status;

    private LocalDateTime dataHoraCompra;

    private BigDecimal precoPago;
}
