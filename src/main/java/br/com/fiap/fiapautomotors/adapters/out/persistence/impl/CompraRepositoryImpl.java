package br.com.fiap.fiapautomotors.adapters.out.persistence.impl;

import br.com.fiap.fiapautomotors.adapters.out.persistence.mapper.CompraEntityMapper;
import br.com.fiap.fiapautomotors.adapters.out.persistence.repository.CompraRepositoryJPA;
import br.com.fiap.fiapautomotors.core.domain.Compra;
import br.com.fiap.fiapautomotors.core.port.out.CompraRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CompraRepositoryImpl implements CompraRepositoryPort {

    private final CompraRepositoryJPA compraRepositoryJPA;

    private final CompraEntityMapper compraEntityMapper;

    public CompraRepositoryImpl(CompraRepositoryJPA compraRepositoryJPA, CompraEntityMapper compraEntityMapper) {
        this.compraRepositoryJPA = compraRepositoryJPA;
        this.compraEntityMapper = compraEntityMapper;
    }

    @Override
    public Optional<Compra> consultarPorId(String id) {
        return compraRepositoryJPA.findById(id)
                .map(compraEntityMapper::toModel);
    }
}
