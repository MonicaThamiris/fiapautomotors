package br.com.fiap.fiapautomotors.adapters.in.controller.response;

import br.com.fiap.fiapautomotors.core.enums.StatusVeiculo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class VeiculoResponse {

    private String id;

    private String marca;

    private String modelo;

    private String ano;

    private String cor;

    private BigDecimal preco;

}
