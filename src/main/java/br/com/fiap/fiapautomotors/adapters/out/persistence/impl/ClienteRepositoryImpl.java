package br.com.fiap.fiapautomotors.adapters.out.persistence.impl;

import br.com.fiap.fiapautomotors.adapters.out.persistence.mapper.ClienteEntityMapper;
import br.com.fiap.fiapautomotors.adapters.out.persistence.repository.ClienteRepositoryJPA;
import br.com.fiap.fiapautomotors.core.domain.Cliente;
import br.com.fiap.fiapautomotors.core.port.out.ClienteRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ClienteRepositoryImpl implements ClienteRepositoryPort {

    private final ClienteRepositoryJPA clienteRepositoryJPA;

    private final ClienteEntityMapper mapper;

    public ClienteRepositoryImpl(ClienteRepositoryJPA clienteRepositoryJPA, ClienteEntityMapper mapper) {
        this.clienteRepositoryJPA = clienteRepositoryJPA;
        this.mapper = mapper;
    }

    @Override
    public Cliente salvar(Cliente cliente) {
        return mapper.toDomain(clienteRepositoryJPA.save(mapper.toEntity(cliente)));
    }

    @Override
    public Optional<Cliente> buscarPorId(String id) {
        return clienteRepositoryJPA.findById(id)
                .map(mapper::toDomain);
    }
}
