package br.com.funeraria.view;

import br.com.funeraria.model.Cliente;
import br.com.funeraria.model.Funcionario;
import br.com.funeraria.model.Pedido;
import br.com.funeraria.model.Servico;
import br.com.funeraria.service.GerenciamentoFuneraria;

import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        GerenciamentoFuneraria sistemaFu = new GerenciamentoFuneraria();
        Scanner sc = new Scanner(System.in);
        System.out.println("O que você deseja fazer: " +
                "\n1 - Cadastrar novo cliente" +
                "\n2 - Cadastrar novo funcionário" +
                "\n3 - Cadastrar novo serviço" +
                "\n4 - Cadastrar novo pedido" +
                "\n5 - Fazer alterações nas listas");
        int opcao = Integer.parseInt(sc.nextLine());
        switch (opcao){
            //Criando o primeiro caso, cadastramento de um NEW CLIENT
            case 1:
                System.out.println("Qual o nome do cliente a ser cadastrado?");
                String nomeCLiente = sc.nextLine();
                System.out.println("Qual o telefone deste cliente?");
                String numeroCliente = sc.nextLine();
                System.out.println("Qual o endereço deste cliente? (Rua/Av, Número, Bairro, Cidade e Estado)");
                String enderecoCliente = sc.nextLine();
                System.out.println("Qual o CPF deste cliente?");
                String cpfCliente = sc.nextLine();
                sistemaFu.adicionarCliente(nomeCLiente, numeroCliente, enderecoCliente, cpfCliente);
                break;
            case 2:
                System.out.println("Qual o nome do funcionario a ser cadastrado?");
                String nomeFuncionario = sc.nextLine();
                System.out.println("Qual será o cargo deste funcionario?");
                String nomeCargo = sc.nextLine();
                sistemaFu.adicionarFuncionario(nomeFuncionario, nomeCargo);
                break;
        }
        sc.close();
    }
}
