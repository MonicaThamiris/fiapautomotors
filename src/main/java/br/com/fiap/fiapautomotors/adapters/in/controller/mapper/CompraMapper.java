package br.com.fiap.fiapautomotors.adapters.in.controller.mapper;

import br.com.fiap.fiapautomotors.adapters.in.controller.request.CriarVeiculoRequest;
import br.com.fiap.fiapautomotors.adapters.in.controller.request.EditarVeiculoRequest;
import br.com.fiap.fiapautomotors.adapters.in.controller.response.CompraResponse;
import br.com.fiap.fiapautomotors.adapters.in.controller.response.ComprarVeiculoResponse;
import br.com.fiap.fiapautomotors.adapters.in.controller.response.ListarVeiculoResponse;
import br.com.fiap.fiapautomotors.adapters.in.controller.response.VeiculoResponse;
import br.com.fiap.fiapautomotors.core.domain.Compra;
import br.com.fiap.fiapautomotors.core.domain.Veiculo;
import org.springframework.stereotype.Component;

@Component
public class CompraMapper {

    public CompraResponse toResponse(Compra compra) {
        if (compra == null){
            return null;
        }

        return new CompraResponse(compra.getId(),
                compra.getCliente().getId(),
                compra.getVeiculo().getId(),
                compra.getDataHoraCompra(),
                compra.getPrecoPago());
    }
}
