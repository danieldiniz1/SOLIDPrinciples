package br.com.alura.rh.model;

public class DadosPessoias {

    private String nome;
    private String cpf;
    private String DDD;
    private String telefone;
    private String email;

    public DadosPessoias() {
    }

    public DadosPessoias(String nome, String cpf, String DDD, String telefone, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.DDD = DDD;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDDD() {
        return DDD;
    }

    public void setDDD(String DDD) {
        this.DDD = DDD;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
