package br.com.fiap.fiapautomotors.adapters.in.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class ClienteResponse {

    private String id;

    private String nome;

    private LocalDate dataNascimento;

    private String documento;

    private String email;

}
