package br.com.alura.rh.validators.impl;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Funcionario;
import br.com.alura.rh.validators.ReajusteSalarioValidator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DefaultReajusteSalarioPercentualValidator implements ReajusteSalarioValidator {

    private BigDecimal reajusteMaximoAprovado = BigDecimal.valueOf(0.4);

    @Override
    public void IsValid(Funcionario funcionario, BigDecimal percentualAumento) {
        if (percentualAumento.compareTo(reajusteMaximoAprovado) > 0) {
            throw new ValidacaoException("O aumento solicitado é " + percentualAumento.subtract(reajusteMaximoAprovado).multiply(BigDecimal.valueOf(100)).toString() + "%" +
                    " é maior que o permitido");
        }

    }
}
