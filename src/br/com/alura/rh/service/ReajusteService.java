package br.com.alura.rh.service;

import br.com.alura.rh.model.Funcionario;
import br.com.alura.rh.validators.ReajusteSalarioValidator;

import java.math.BigDecimal;

public class ReajusteService {

    private ReajusteSalarioValidator reajusteSalarioValidator;

    public void reajustarSalarioDoFuncionario(Funcionario funcionario, BigDecimal valorAumento){

        reajusteSalarioValidator.percentualDeReajusteIsValid(valorAumento);
        reajusteSalarioValidator.dataReajusteIsValid(funcionario);

        BigDecimal salarioAtual = funcionario.getSalario();
        BigDecimal salarioAtualizado = salarioAtual.multiply(valorAumento.add(BigDecimal.ONE));
        funcionario.atualizarSalario(salarioAtualizado);
    }

    public ReajusteSalarioValidator getReajusteSalarioValidator() {
        return reajusteSalarioValidator;
    }

    public void setReajusteSalarioValidator(ReajusteSalarioValidator reajusteSalarioValidator) {
        this.reajusteSalarioValidator = reajusteSalarioValidator;
    }
}
