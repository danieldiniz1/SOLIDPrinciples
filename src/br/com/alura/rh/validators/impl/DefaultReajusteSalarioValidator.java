package br.com.alura.rh.validators.impl;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Funcionario;
import br.com.alura.rh.validators.ReajusteSalarioValidator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DefaultReajusteSalarioValidator implements ReajusteSalarioValidator {

    private BigDecimal reajusteMaximoAprovado = BigDecimal.valueOf(0.4);

    public Boolean percentualDeReajusteIsValid(BigDecimal valorAumento) {
        if (valorAumento.compareTo(valorAumento) > 0) {
            throw new ValidacaoException("O aumento solicitado é " + valorAumento.subtract(reajusteMaximoAprovado).multiply(BigDecimal.valueOf(100)).toString() + "%" +
                    "maior que o permitido");
        }
        return Boolean.FALSE;
    }

    @Override
    public Boolean dataReajusteIsValid(Funcionario funcionario) {
        long mesesEntreReajuste = ChronoUnit.MONTHS.between(funcionario.getDataUltimoReajuste(), LocalDate.now());
        if (mesesEntreReajuste < 6L){
            throw new ValidacaoException("O último reajuste foi em " + mesesEntreReajuste + ". " +
                    "O mínimo que deve ser considerado é 6 meses.");
        }
        return Boolean.FALSE;
    }
}
