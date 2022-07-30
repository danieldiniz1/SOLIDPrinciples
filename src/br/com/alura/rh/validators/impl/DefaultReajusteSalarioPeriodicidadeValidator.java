package br.com.alura.rh.validators.impl;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Funcionario;
import br.com.alura.rh.validators.ReajusteSalarioValidator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DefaultReajusteSalarioPeriodicidadeValidator implements ReajusteSalarioValidator {
    @Override
    public void IsValid(Funcionario funcionario, BigDecimal percentualAumento) {
        long mesesEntreReajuste = ChronoUnit.MONTHS.between(funcionario.getDataUltimoReajuste(), LocalDate.now());
        if (mesesEntreReajuste < 6L){
            throw new ValidacaoException("O último reajuste foi em " + mesesEntreReajuste + ". " +
                    "O mínimo que deve ser considerado é 6 meses.");
        }
    }
}
