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
        while (true){
            System.out.println("O que você deseja fazer: " +
                    "\n1 - Cadastrar novo cliente" +
                    "\n2 - Cadastrar novo funcionário" +
                    "\n3 - Cadastrar novo serviço" +
                    "\n4 - Cadastrar novo pedido" +
                    "\n5 - Fazer alterações nas listas");
            int opcao = Integer.parseInt(sc.nextLine());
            if (opcao == 0){
                break;
            }
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
                    //cadastrando novo funcionario
                    System.out.println("Qual o nome do funcionario a ser cadastrado?");
                    String nomeFuncionario = sc.nextLine();
                    System.out.println("Qual será o cargo deste funcionario?");
                    String nomeCargo = sc.nextLine();
                    sistemaFu.adicionarFuncionario(nomeFuncionario, nomeCargo);
                    break;
                case 3:
                    //cadastrando novo serviço
                    System.out.println("Como será o serviço oferecido? (Descrição do serviço)");
                    String descricao = sc.nextLine();
                    System.out.println("Qual será o preço deste serviço?");
                    double preco = Double.parseDouble(sc.nextLine());
                    sistemaFu.adicionarServico(descricao, preco);
                    break;
                case 4:
                    //cadastrando novo pedido (precisa de cliente, funcionario e serviço para fazer)
                    System.out.println("Qual é o nome do cliente que irá receber o serviço?");
                    String clienteEscolhi = sc.nextLine();
                    System.out.println("Qual o CPF desse cliente?");
                    String cpfClienteEscolhi = sc.nextLine();
                    Cliente novoClientePedido = sistemaFu.consultarClientes(clienteEscolhi, cpfClienteEscolhi);
                    if (novoClientePedido == null) {
                        System.out.println("Cliente não encontrado!");
                        break;
                    }

                    System.out.println("Qual o tipo de Serviço será oferecido?");
                    String descriEscolhi = sc.nextLine();
                    System.out.println("Qual o preço desse serviço?");
                    double precoEscolhi = Double.parseDouble(sc.nextLine());
                    Servico novoServicoPedido = sistemaFu.consultarServicos(descriEscolhi, precoEscolhi);
                    if (novoServicoPedido == null) {
                        System.out.println("Serviço não encontrado!");
                        break;
                    }

                    System.out.println("Qual funcionario irá ficar responsável por este pedido?");
                    String funcionarioEscolhi = sc.nextLine();
                    System.out.println("Qual o cargo do funcionario?");
                    String cargoEscolhi = sc.nextLine();
                    Funcionario novoFuncionarioPedido = sistemaFu.consultarFuncionarios(funcionarioEscolhi, cargoEscolhi);
                    if (novoFuncionarioPedido == null) {
                        System.out.println("Funcionario não encontrado!");
                        break;
                    }

                    sistemaFu.adicionarPedido(
                            novoClientePedido,
                            novoServicoPedido,
                            novoFuncionarioPedido,
                            "99/99/9999"
                    );
                    break;
                case 5:
                    break;
            }
        }
        sc.close();
    }
}
