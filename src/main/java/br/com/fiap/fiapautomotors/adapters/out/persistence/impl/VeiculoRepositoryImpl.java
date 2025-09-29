package br.com.fiap.fiapautomotors.adapters.out.persistence.impl;

import br.com.fiap.fiapautomotors.adapters.out.persistence.mapper.CompraEntityMapper;
import br.com.fiap.fiapautomotors.adapters.out.persistence.mapper.VeiculoEntityMapper;
import br.com.fiap.fiapautomotors.adapters.out.persistence.repository.CompraRepositoryJPA;
import br.com.fiap.fiapautomotors.adapters.out.persistence.repository.VeiculoRepositoryJPA;
import br.com.fiap.fiapautomotors.core.domain.Cliente;
import br.com.fiap.fiapautomotors.core.domain.Veiculo;
import br.com.fiap.fiapautomotors.core.enums.StatusVeiculo;
import br.com.fiap.fiapautomotors.core.port.out.VeiculoRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class VeiculoRepositoryImpl implements VeiculoRepositoryPort {

    private final VeiculoRepositoryJPA veiculoRepositoryJPA;

    private final CompraRepositoryJPA compraRepositoryJPA;

    private final VeiculoEntityMapper veiculoEntityMapper;

    private final CompraEntityMapper compraEntityMapper;

    public VeiculoRepositoryImpl(VeiculoRepositoryJPA veiculoRepositoryJPA, CompraRepositoryJPA compraRepositoryJPA,
                                 VeiculoEntityMapper veiculoEntityMapper, CompraEntityMapper compraEntityMapper) {
        this.veiculoRepositoryJPA = veiculoRepositoryJPA;
        this.compraRepositoryJPA = compraRepositoryJPA;
        this.veiculoEntityMapper = veiculoEntityMapper;
        this.compraEntityMapper = compraEntityMapper;
    }

    @Override
    public Veiculo salvar(Veiculo veiculo) {
        return veiculoEntityMapper.toDomain(veiculoRepositoryJPA.save(veiculoEntityMapper.toEntity(veiculo)));
    }

    @Override
    public Optional<Veiculo> buscarPorId(String id) {
        return veiculoRepositoryJPA.findById(id)
                .map(veiculoEntityMapper::toDomain);
    }

    @Override
    public List<Veiculo> consultarPorStatus(StatusVeiculo status) {
        return veiculoRepositoryJPA.findByStatusOrderByPrecoAsc(status).stream()
                .map(veiculoEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Veiculo> consultarTodos() {
        return veiculoRepositoryJPA.findAll().stream()
                .map(veiculoEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Veiculo registrarCompra(Cliente cliente, Veiculo veiculo) {
        var registrada = compraRepositoryJPA.save(compraEntityMapper.toEntity(cliente, veiculo));
        return new Veiculo(veiculo.getId(), veiculo.getStatus(), registrada.getDataHora(), veiculo.getPreco(), registrada.getId());
    }
}
