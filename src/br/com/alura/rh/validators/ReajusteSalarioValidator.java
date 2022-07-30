package br.com.alura.rh.validators;

import br.com.alura.rh.model.Funcionario;

import java.math.BigDecimal;

public interface ReajusteSalarioValidator {

    void IsValid(Funcionario funcionario, BigDecimal percentualAumento);
}
