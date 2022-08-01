package br.com.alura.rh.model;

import java.math.BigDecimal;

public class Terceirizado {

    private DadosPessoias dadosPessoias;
    private String Empresa;

    public Terceirizado() {
    }

    public Terceirizado(String nome, String cpf) {
        this.dadosPessoias.setCpf(cpf);
        this.dadosPessoias.setNome(nome);
    }

    public String getEmpresa() {
        return Empresa;
    }

    public void setEmpresa(String empresa) {
        Empresa = empresa;
    }
}
