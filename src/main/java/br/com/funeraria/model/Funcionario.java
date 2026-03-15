package br.com.funeraria.model;

import java.util.concurrent.atomic.AtomicInteger;

public class Funcionario {
    private static final AtomicInteger contador = new AtomicInteger(1);
    private String nome;
    private String cargo;
    private int idFuncionario;

    public Funcionario(String nome, String cargo){
        this.nome = nome;
        this.cargo = cargo;
        //Defini sempre um valor crescente para gerar novos Ids --> poderia ser feito apenas com um (contador++)
        this.idFuncionario = contador.getAndIncrement();
    }

    public Funcionario(){
        this("Sem nome", "Não possui cargo");
    }

    public String getNome() {return nome;}
    public String getCargo() {return cargo;}
    public int getIdFuncionario() {return idFuncionario;}

    public void setNome(String nome) {this.nome = nome;}
    public void setCargo(String cargo) {this.cargo = cargo;}
}
