package br.com.fiap.fiapautomotors.core.usecase;

import br.com.fiap.fiapautomotors.core.domain.Compra;
import br.com.fiap.fiapautomotors.core.port.in.ConsultarCompraUseCasePort;
import br.com.fiap.fiapautomotors.core.port.out.CompraRepositoryPort;
import org.springframework.stereotype.Component;

@Component
public class ConsultarCompraUseCase implements ConsultarCompraUseCasePort {

    private final CompraRepositoryPort compraRepositoryPort;

    public ConsultarCompraUseCase(CompraRepositoryPort compraRepositoryPort) {
        this.compraRepositoryPort = compraRepositoryPort;
    }

    @Override
    public Compra consultar(String id) {
        return compraRepositoryPort.consultarPorId(id).orElse(null);
    }
}
