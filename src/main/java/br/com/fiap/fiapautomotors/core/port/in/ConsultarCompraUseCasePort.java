package br.com.fiap.fiapautomotors.core.port.in;

import br.com.fiap.fiapautomotors.core.domain.Compra;

public interface ConsultarCompraUseCasePort {

    Compra consultar(String id);
}
