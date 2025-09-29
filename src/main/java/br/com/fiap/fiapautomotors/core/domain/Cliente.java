package br.com.fiap.fiapautomotors.core.domain;

import java.time.LocalDate;

public class Cliente {

    private String id;

    private String nome;

    private LocalDate dataNascimento;

    private String documento;

    private String email;

    private String senha;

    public Cliente(String nome, LocalDate dataNascimento, String documento, String email, String senha) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.documento = documento;
        this.email = email;
        this.senha = senha;
    }

    public Cliente(String id, String nome, LocalDate dataNascimento, String documento, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.documento = documento;
        this.email = email;
        this.senha = senha;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
}
