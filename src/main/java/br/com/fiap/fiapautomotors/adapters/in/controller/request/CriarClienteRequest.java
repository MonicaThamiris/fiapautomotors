package br.com.fiap.fiapautomotors.adapters.in.controller.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Data
public class CriarClienteRequest {

    private String nome;

    private LocalDate dataNascimento;

    private String documento;

    private String email;

    private String senha;
}
