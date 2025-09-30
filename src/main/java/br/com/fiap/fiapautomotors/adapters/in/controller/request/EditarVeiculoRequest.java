package br.com.fiap.fiapautomotors.adapters.in.controller.request;

import br.com.fiap.fiapautomotors.core.enums.StatusVeiculo;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class EditarVeiculoRequest {

    private String marca;

    private String modelo;

    private String ano;

    private String cor;

    private BigDecimal preco;
}
