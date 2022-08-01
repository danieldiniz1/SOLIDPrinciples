package br.com.alura.rh.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import br.com.alura.rh.ValidacaoException;

public class Funcionario {

	private DadosPessoias dadosPessoias;
	private Cargo cargo;
	private BigDecimal salario;
	private LocalDate dataUltimoReajuste;

	public Funcionario() {
	}

	public Funcionario(String nome, String cpf, Cargo cargo, BigDecimal salario) {
		this.dadosPessoias.setNome(nome);
		this.dadosPessoias.setCpf(cpf);
		this.cargo = cargo;
		this.salario = salario;
	}

	public void reajustarSalario(BigDecimal aumento) {
		BigDecimal percentualReajuste = aumento.divide(salario, RoundingMode.HALF_UP);
		if (percentualReajuste.compareTo(new BigDecimal("0.4")) > 0) {
			throw new ValidacaoException("Reajuste nao pode ser superior a 40% do salario!");
		}
		this.salario = this.salario.add(aumento);
		this.dataUltimoReajuste = LocalDate.now();
	}

	public DadosPessoias getDadosPessoias() {
		return dadosPessoias;
	}

	public void setDadosPessoias(DadosPessoias dadosPessoias) {
		this.dadosPessoias = dadosPessoias;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public LocalDate getDataUltimoReajuste() {
		return dataUltimoReajuste;
	}

	public void setDataUltimoReajuste(LocalDate dataUltimoReajuste) {
		this.dataUltimoReajuste = dataUltimoReajuste;
	}

	public void atualizarSalario(BigDecimal salarioAtualizado) {
		setSalario(salarioAtualizado);
		setDataUltimoReajuste(LocalDate.now());
	}

	public void promover(Cargo cargoNovo) {
		setCargo(cargoNovo);
	}
}
