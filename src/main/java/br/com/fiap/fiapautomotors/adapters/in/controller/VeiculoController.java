package br.com.fiap.fiapautomotors.adapters.in.controller;

import br.com.fiap.fiapautomotors.adapters.in.controller.mapper.VeiculoMapper;
import br.com.fiap.fiapautomotors.adapters.in.controller.request.CriarVeiculoRequest;
import br.com.fiap.fiapautomotors.adapters.in.controller.request.EditarVeiculoRequest;
import br.com.fiap.fiapautomotors.adapters.in.controller.response.ComprarVeiculoResponse;
import br.com.fiap.fiapautomotors.adapters.in.controller.response.ListarVeiculoResponse;
import br.com.fiap.fiapautomotors.adapters.in.controller.response.VeiculoResponse;
import br.com.fiap.fiapautomotors.core.domain.Veiculo;
import br.com.fiap.fiapautomotors.core.enums.StatusVeiculo;
import br.com.fiap.fiapautomotors.core.port.in.ComprarVeiculoUseCasePort;
import br.com.fiap.fiapautomotors.core.port.in.CriarVeiculoUseCasePort;
import br.com.fiap.fiapautomotors.core.port.in.EditarVeiculoUseCasePort;
import br.com.fiap.fiapautomotors.core.port.in.ConsultarVeiculosUseCasePort;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/veiculo")
@RequiredArgsConstructor
public class VeiculoController {

    private final CriarVeiculoUseCasePort criarVeiculoUseCasePort;

    private final EditarVeiculoUseCasePort editarVeiculoUseCasePort;

    private final ConsultarVeiculosUseCasePort listarVeiculosUseCasePort;

    private final ComprarVeiculoUseCasePort comprarVeiculoUseCasePort;

    private final VeiculoMapper veiculoMapper;

    @PostMapping
    public ResponseEntity<VeiculoResponse> criarVeiculo(@RequestBody CriarVeiculoRequest criarVeiculoRequest) {
        Veiculo veiculo = veiculoMapper.toModel(criarVeiculoRequest);

        var response = criarVeiculoUseCasePort.criar(veiculo);

        return ResponseEntity.status(201).body(veiculoMapper.toResponse(response));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<VeiculoResponse> editarVeiculo(@PathVariable String id, @RequestBody EditarVeiculoRequest editarVeiculoRequest) {
        Veiculo veiculo = veiculoMapper.toModel(editarVeiculoRequest);

        var response = editarVeiculoUseCasePort.editar(id, veiculo);

        return ResponseEntity.status(200).body(veiculoMapper.toResponse(response));
    }

    @GetMapping
    public ResponseEntity<List<ListarVeiculoResponse>> listarVeiculos(@RequestParam(required = false) StatusVeiculo status) {
        return ResponseEntity.status(200).body(listarVeiculosUseCasePort.consultar(status).stream()
                .map(veiculoMapper::toResponseListar)
                .collect(Collectors.toList()));
    }

    @PostMapping("/{id}/comprar")
    public ResponseEntity<ComprarVeiculoResponse> comprarVeiculo(@PathVariable String id, HttpServletRequest request) {
        String userId = (String) request.getAttribute("userSub");

        return ResponseEntity.status(201)
                .body(veiculoMapper.toResponseComprar(comprarVeiculoUseCasePort.comprar(userId, id)));
    }
}