package br.com.fiap.fiapautomotors.adapters.in.controller;

import br.com.fiap.fiapautomotors.adapters.in.controller.mapper.ClienteMapper;
import br.com.fiap.fiapautomotors.adapters.in.controller.request.CriarClienteRequest;
import br.com.fiap.fiapautomotors.adapters.in.controller.request.EditarVeiculoRequest;
import br.com.fiap.fiapautomotors.adapters.in.controller.response.ClienteResponse;
import br.com.fiap.fiapautomotors.adapters.in.controller.response.VeiculoResponse;
import br.com.fiap.fiapautomotors.core.domain.Cliente;
import br.com.fiap.fiapautomotors.core.domain.Veiculo;
import br.com.fiap.fiapautomotors.core.port.in.CriarClienteUseCasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteMapper clienteMapper;

    private final CriarClienteUseCasePort criarClienteUseCasePort;

    @PostMapping
    public ResponseEntity<ClienteResponse> criarCliente(@RequestBody CriarClienteRequest criarClienteRequest) {
        Cliente cliente = clienteMapper.toModel(criarClienteRequest);

        var response = criarClienteUseCasePort.criar(cliente);

        return ResponseEntity.status(201).body(clienteMapper.toResponse(response));
    }
}
