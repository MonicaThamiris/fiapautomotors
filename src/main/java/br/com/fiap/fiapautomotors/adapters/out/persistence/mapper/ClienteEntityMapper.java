package br.com.fiap.fiapautomotors.adapters.out.persistence.mapper;

import br.com.fiap.fiapautomotors.adapters.out.persistence.entities.ClienteEntity;
import br.com.fiap.fiapautomotors.core.domain.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteEntityMapper {

    public ClienteEntity toEntity(Cliente cliente){
        if (cliente == null){
            return null;
        }

        return new ClienteEntity(cliente.getId(),
                cliente.getNome(),
                cliente.getDataNascimento(),
                cliente.getDocumento(),
                cliente.getEmail(),
                cliente.getSenha());
    }

    public Cliente toDomain(ClienteEntity clienteEntity){
        if (clienteEntity == null){
            return null;
        }

        return new Cliente(clienteEntity.getId(),
                clienteEntity.getNome(),
                clienteEntity.getDataNascimento(),
                clienteEntity.getDocumento(),
                clienteEntity.getEmail(),
                clienteEntity.getSenha());
    }
}
