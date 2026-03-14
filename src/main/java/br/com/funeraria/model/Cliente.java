package br.com.funeraria.model;

public class Cliente {
    private String nome;
    private String telefone;
    private String endereco;
    private String cpf;

    public Cliente(String nome, String telefone, String endereco, String cpf){
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cpf = cpf;
    }

    public Cliente(){
        this("Sem nome", "Sem telefone", "Sem email", "Sem CPF");
    }

    public String getNome() {return nome;}
    public String getTelefone() {return telefone;}
    public String getEndereco() {return endereco;}
    public String getCpf() {return cpf;}

    public void setNome(String nome) {this.nome = nome;}
    public void setTelefone(String telefone) {this.telefone = telefone;}
    public void setEndereco(String endereco) {this.endereco = endereco;}
    public void setCpf(String cpf) {this.cpf = cpf;}


    public Cliente adicionarCliente(String nome, String telef, String ender, String cpf){
         return new Cliente(nome, telef, ender, cpf);
    }
}
