package br.com.fiap.fiapautomotors.adapters.in.controller.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CriarVeiculoRequest {

    private String marca;

    private String modelo;

    private String ano;

    private String cor;

    private BigDecimal preco;
}
