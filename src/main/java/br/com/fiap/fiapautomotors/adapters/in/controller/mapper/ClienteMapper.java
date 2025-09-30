package br.com.fiap.fiapautomotors.adapters.in.controller.mapper;

import br.com.fiap.fiapautomotors.adapters.in.controller.request.CriarClienteRequest;
import br.com.fiap.fiapautomotors.adapters.in.controller.response.ClienteResponse;
import br.com.fiap.fiapautomotors.core.domain.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public Cliente toModel(CriarClienteRequest criarClienteRequest){
        return new Cliente(criarClienteRequest.getNome(),
                criarClienteRequest.getDataNascimento(),
                criarClienteRequest.getDocumento(),
                criarClienteRequest.getEmail(),
                criarClienteRequest.getSenha());
    }

    public ClienteResponse toResponse(Cliente cliente){
        return new ClienteResponse(cliente.getId(),
                cliente.getNome(),
                cliente.getDataNascimento(),
                cliente.getDocumento(),
                cliente.getEmail());
    }
}
