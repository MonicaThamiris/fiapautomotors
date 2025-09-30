package br.com.fiap.fiapautomotors.core.usecase;

import br.com.fiap.fiapautomotors.core.domain.Cliente;
import br.com.fiap.fiapautomotors.core.domain.Veiculo;
import br.com.fiap.fiapautomotors.core.enums.StatusVeiculo;
import br.com.fiap.fiapautomotors.core.port.in.ComprarVeiculoUseCasePort;
import br.com.fiap.fiapautomotors.core.port.out.ClienteRepositoryPort;
import br.com.fiap.fiapautomotors.core.port.out.VeiculoRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ComprarVeiculosUseCase implements ComprarVeiculoUseCasePort {

    private final VeiculoRepositoryPort veiculoRepositoryPort;

    private final ClienteRepositoryPort clienteRepositoryPort;

    public ComprarVeiculosUseCase(VeiculoRepositoryPort veiculoRepositoryPort,
                                  ClienteRepositoryPort clienteRepositoryPort) {
        this.veiculoRepositoryPort = veiculoRepositoryPort;
        this.clienteRepositoryPort = clienteRepositoryPort;
    }

    @Override
    public Veiculo comprar(String idCliente, String id) {
        Cliente cliente = clienteRepositoryPort.buscarPorId(idCliente)
                .orElseThrow(() -> new RuntimeException(
                        String.format("O cliente de ID %s não existe", idCliente)));

        Veiculo veiculo = veiculoRepositoryPort.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException(
                        String.format("O veículo de ID %s não existe", id)));

        if (!veiculo.getStatus().equals(StatusVeiculo.DISPONIVEL)){
            throw new RuntimeException(String.format("O veículo de ID %s não está disponível para compra", id));
        }

        veiculo.setStatus(StatusVeiculo.VENDIDO);
        var veiculoAtualizado = veiculoRepositoryPort.salvar(veiculo);

        return veiculoRepositoryPort.registrarCompra(cliente, veiculoAtualizado);
    }
}
