package br.com.funeraria.model;
import java.util.Objects;

public class Cliente {
    private String nomeCliente;
    private String telefone;
    private String endereco;
    private String cpfCliente;

    public Cliente(String nome, String telefone, String endereco, String cpf){
       this.nomeCliente = nome;
       this.telefone = telefone;
       this.endereco = endereco;
       this.cpfCliente = cpf;
    }
    public Cliente() {
        this("Sem nome", "Sem telefone", "Sem email", "Sem CPF");
    }

    public String getNomeCliente() {return nomeCliente;}
    public String getTelefone() {return telefone;}
    public String getEndereco() {return endereco;}
    public String getCpfCliente() {return cpfCliente;}

    public void setNomeCliente(String nomeCliente) {this.nomeCliente = nomeCliente;}
    public void setTelefone(String telefone) {this.telefone = telefone;}
    public void setEndereco(String endereco) {this.endereco = endereco;}
    public void setCpfCliente(String cpfCliente) {this.cpfCliente = cpfCliente;}

    public static Cliente fromFileString(String linha) {
        String[] partes = linha.split(";");

        Cliente cliente = new Cliente();
        cliente.setNomeCliente(partes[0]);
        cliente.setCpfCliente(partes[1]);

        return cliente;
    }

    @Override
    public String toString() {
        return "Cliente: " + nomeCliente +
                "\nDe CPF: " + cpfCliente +
                "\nDe telefone: " + telefone +
                "\nQue reside em " + endereco;
    }
}