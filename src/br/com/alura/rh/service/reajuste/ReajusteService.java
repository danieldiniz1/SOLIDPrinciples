package br.com.alura.rh.service.reajuste;

import br.com.alura.rh.model.Funcionario;
import br.com.alura.rh.validators.ReajusteSalarioValidator;

import java.math.BigDecimal;
import java.util.List;

public class ReajusteService {

    private List<ReajusteSalarioValidator> validacoes;

    public ReajusteService(List<ReajusteSalarioValidator> validacoes) {
        this.validacoes = validacoes;
    }

    public void reajustarSalarioDoFuncionario(Funcionario funcionario, BigDecimal valorAumento){
        this.validacoes.forEach(v -> v.IsValid(funcionario, valorAumento));

        BigDecimal salarioAtual = funcionario.getSalario();
        BigDecimal salarioAtualizado = salarioAtual.multiply(valorAumento.add(BigDecimal.ONE));
        funcionario.atualizarSalario(salarioAtualizado);
    }
}
