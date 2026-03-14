package br.com.funeraria.model;

public class Funcionario {
    private String nome;
    private String cargo;
    private String idFuncionario;

    public Funcionario(String nome, String cargo, String idFuncionario){
        this.nome = nome;
        this.cargo = cargo;
        this.idFuncionario = idFuncionario;
    }

    public Funcionario(){
        this("Sem nome", "Não possui cargo", "0");
    }

    public String getNome() {return nome;}
    public String getCargo() {return cargo;}
    public String getIdFuncionario() {return idFuncionario;}

    public void setNome(String nome) {this.nome = nome;}
    public void setCargo(String cargo) {this.cargo = cargo;}
    public void setIdFuncionario(String idFuncionario) {this.idFuncionario = idFuncionario;}

    public Funcionario adicionarFuncionario(String nome, String cargo, String idFuncionario){
        // Criar um gerador de ids para o usuario não precisar gerar um ID
        return new Funcionario(nome, cargo, idFuncionario);
    }
}
