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
        this("", "");
    }

    public String getNome() {return nome;}
    public String getCargo() {return cargo;}
    public int getIdFuncionario() {return idFuncionario;}

    public void setNome(String nome) {this.nome = nome;}
    public void setCargo(String cargo) {this.cargo = cargo;}
    public void setIdFuncionario(int idFuncionario) {this.idFuncionario = idFuncionario;}

    public static Funcionario fromFileString(String linha) {
        String[] partes = linha.split(";");

        Funcionario funcionario = new Funcionario();
        funcionario.setNome(partes[0]);
        funcionario.setCargo(partes[1]);
        funcionario.setIdFuncionario(Integer.parseInt(partes[2]));

        return funcionario;
    }

    public String toString(){
        return "Funcionário: " + nome +
                "\nNo cargo de: " + cargo +
                "\nDe Id: " + idFuncionario;
    }
}
