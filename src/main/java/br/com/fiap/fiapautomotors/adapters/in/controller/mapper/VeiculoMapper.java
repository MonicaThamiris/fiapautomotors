package br.com.fiap.fiapautomotors.adapters.in.controller.mapper;

import br.com.fiap.fiapautomotors.adapters.in.controller.request.CriarVeiculoRequest;
import br.com.fiap.fiapautomotors.adapters.in.controller.request.EditarVeiculoRequest;
import br.com.fiap.fiapautomotors.adapters.in.controller.response.ComprarVeiculoResponse;
import br.com.fiap.fiapautomotors.adapters.in.controller.response.ListarVeiculoResponse;
import br.com.fiap.fiapautomotors.adapters.in.controller.response.VeiculoResponse;
import br.com.fiap.fiapautomotors.core.domain.Veiculo;
import org.springframework.stereotype.Component;

@Component
public class VeiculoMapper {

    public Veiculo toModel(CriarVeiculoRequest criarVeiculoRequest){
        return new Veiculo(criarVeiculoRequest.getMarca(),
                criarVeiculoRequest.getModelo(),
                criarVeiculoRequest.getAno(),
                criarVeiculoRequest.getCor(),
                criarVeiculoRequest.getPreco());
    }

    public Veiculo toModel(EditarVeiculoRequest editarVeiculoRequest){
        return new Veiculo(editarVeiculoRequest.getMarca(),
                editarVeiculoRequest.getModelo(),
                editarVeiculoRequest.getAno(),
                editarVeiculoRequest.getCor(),
                editarVeiculoRequest.getPreco());
    }

    public VeiculoResponse toResponse(Veiculo veiculo){
        return new VeiculoResponse(veiculo.getId(),
                veiculo.getMarca(),
                veiculo.getModelo(),
                veiculo.getAno(),
                veiculo.getCor(),
                veiculo.getPreco());
    }

    public ListarVeiculoResponse toResponseListar(Veiculo veiculo){
        return new ListarVeiculoResponse(veiculo.getId(),
                veiculo.getMarca(),
                veiculo.getModelo(),
                veiculo.getAno(),
                veiculo.getCor(),
                veiculo.getPreco(),
                veiculo.getStatus(),
                veiculo.getDataHoraCriacao(),
                veiculo.getDataHoraAtualizacao());
    }

    public ComprarVeiculoResponse toResponseComprar(Veiculo veiculo){
        return new ComprarVeiculoResponse(veiculo.getIdCompra(),
                veiculo.getStatus(),
                veiculo.getDataHoraCompra(),
                veiculo.getPreco());
    }

}
