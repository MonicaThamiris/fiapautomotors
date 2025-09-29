package br.com.fiap.fiapautomotors.adapters.in.controller;

import br.com.fiap.fiapautomotors.adapters.in.controller.mapper.CompraMapper;
import br.com.fiap.fiapautomotors.adapters.in.controller.response.CompraResponse;
import br.com.fiap.fiapautomotors.core.port.in.ComprarVeiculoUseCasePort;
import br.com.fiap.fiapautomotors.core.port.in.ConsultarCompraUseCasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/compra")
@RequiredArgsConstructor
public class CompraController {


    private final ConsultarCompraUseCasePort consultarCompraUseCasePort;

    private final CompraMapper compraMapper;

    @GetMapping("/{id}")
    public ResponseEntity<CompraResponse> consultarCompra(@PathVariable String id) {
        return ResponseEntity.status(200).body(compraMapper.toResponse(consultarCompraUseCasePort.consultar(id)));
    }
}