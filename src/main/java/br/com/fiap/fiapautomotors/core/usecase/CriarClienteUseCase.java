package br.com.fiap.fiapautomotors.core.usecase;

import br.com.fiap.fiapautomotors.core.domain.Cliente;
import br.com.fiap.fiapautomotors.core.domain.Veiculo;
import br.com.fiap.fiapautomotors.core.port.in.CriarClienteUseCasePort;
import br.com.fiap.fiapautomotors.core.port.in.CriarVeiculoUseCasePort;
import br.com.fiap.fiapautomotors.core.port.out.ClienteIntegracaoPort;
import br.com.fiap.fiapautomotors.core.port.out.ClienteRepositoryPort;
import br.com.fiap.fiapautomotors.core.port.out.VeiculoRepositoryPort;
import org.springframework.stereotype.Component;

@Component
public class CriarClienteUseCase implements CriarClienteUseCasePort {

    private final ClienteRepositoryPort clienteRepositoryPort;

    private final ClienteIntegracaoPort clienteIntegracaoPort;

    public CriarClienteUseCase(ClienteRepositoryPort clienteRepositoryPort, ClienteIntegracaoPort clienteIntegracaoPort) {
        this.clienteRepositoryPort = clienteRepositoryPort;
        this.clienteIntegracaoPort = clienteIntegracaoPort;
    }

    @Override
    public Cliente criar(Cliente cliente) {
        Cliente novoCliente = new Cliente(
                clienteIntegracaoPort.cadastrar(cliente.getEmail(), cliente.getSenha()),
                cliente.getNome(),
                cliente.getDataNascimento(),
                cliente.getDocumento(),
                cliente.getEmail(),
                cliente.getSenha()
        );

        return clienteRepositoryPort.salvar(novoCliente);
    }
}
