package br.com.fiap.fiapautomotors.core.enums;

public enum StatusVeiculo {
    DISPONIVEL,
    VENDIDO;

    public static StatusVeiculo fromString(String value){
        if (value == null ) {
            return null;
        }

        try {
            return StatusVeiculo.valueOf(value.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Status do veículo inválido");
        }
    }
}
