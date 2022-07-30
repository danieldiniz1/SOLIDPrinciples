package br.com.alura.rh.service;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Funcionario;

import java.math.BigDecimal;

public class ReajusteService {

    private BigDecimal reajusteMaximoAprovado = BigDecimal.valueOf(0.4);



    public void reajustarSalarioDoFuncionario(Funcionario funcionario, BigDecimal valorAumento){
        BigDecimal salarioAtual = funcionario.getSalario();
        if (valorAumento.compareTo(valorAumento) == 1){
            throw new ValidacaoException("O aumento solicitado é " + valorAumento.subtract(reajusteMaximoAprovado).multiply(BigDecimal.valueOf(100)).toString() + "%" +
                    "maior que o permitido");
        }
        BigDecimal salarioAtualizado = salarioAtual.multiply(valorAumento.add(BigDecimal.ONE));
        funcionario.atualizarSalario(salarioAtualizado);
    }
}
