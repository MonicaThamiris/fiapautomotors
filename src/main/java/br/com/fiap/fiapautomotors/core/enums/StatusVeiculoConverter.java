package br.com.fiap.fiapautomotors.core.enums;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StatusVeiculoConverter implements Converter<String, StatusVeiculo> {
    @Override
    public StatusVeiculo convert(String source) {
        return StatusVeiculo.fromString(source);
    }
}
