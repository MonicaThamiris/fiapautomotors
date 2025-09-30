package br.com.fiap.fiapautomotors.core.port.out;

import br.com.fiap.fiapautomotors.core.domain.Cliente;

import java.util.Optional;

public interface ClienteRepositoryPort {

    Cliente salvar(Cliente cliente);

    Optional<Cliente> buscarPorId(String id);
}
