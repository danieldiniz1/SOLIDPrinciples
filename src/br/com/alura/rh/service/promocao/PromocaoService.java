package br.com.alura.rh.service.promocao;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Cargo;
import br.com.alura.rh.model.Funcionario;

public class PromocaoService {

    public void promover(Funcionario funcionario, Boolean metaBatida){
        Cargo cargoAtual = funcionario.getCargo();
        if (cargoAtual.equals(Cargo.GERENTE)){
            throw new ValidacaoException("O Gerente não pode ser promovido!");
        }

        if (metaBatida){
            Cargo cargoNovo = cargoAtual.getProximoCargo();
            funcionario.promover(cargoNovo);
        }

    }
}
