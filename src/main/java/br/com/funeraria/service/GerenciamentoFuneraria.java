package br.com.funeraria.service;

import br.com.funeraria.model.Cliente;
import br.com.funeraria.model.Funcionario;
import br.com.funeraria.model.Pedido;
import br.com.funeraria.model.Servico;

import java.util.ArrayList;
import java.util.List;

public class GerenciamentoFuneraria {

    List<Cliente> clientes = new ArrayList<>();
    List<Funcionario> funcionarios = new ArrayList<>();
    List<Servico> servicos = new ArrayList<>();
    List<Pedido> pedidos = new ArrayList<>();


    //Consultas --->
    public void consultarClientes(String nome, String cpf){
        for (Cliente c: clientes){
            if (c.getNome().equalsIgnoreCase(nome) && c.getCpf().equalsIgnoreCase(cpf)){
                System.out.println(c);
            }
        }
    }
    public void consultarFuncionarios(String nome, int idFuncionario){
        for (Funcionario f: funcionarios){
            if (f.getNome().equalsIgnoreCase(nome) && f.getIdFuncionario()==(idFuncionario)){
                System.out.println(f);
            }
        }
    }
    public void consultarServicos(String descricao){
        for (Servico s: servicos){
            if (s.getDescricao().equalsIgnoreCase(descricao)){
                System.out.println(s);
            }
        }
    }
    public void consultarPedidos(){
        for (Pedido p: pedidos){
            System.out.println(p);
        }
    }
    //Consultas <---

    //Cadastramentos --->
    public void adicionarCliente(String nome, String telefone, String endereco, String cpf){
        clientes.add(new Cliente(nome, telefone, endereco, cpf));
    }

    public void adicionarFuncionario(String nome, String cargo){
        funcionarios.add(new Funcionario(nome, cargo));
    }

    public void adicionarServico(String descricao, double preco){
        servicos.add(new Servico(descricao, preco));
    }

    public void adicionarPedido(Cliente cliente, Servico servico, Funcionario funcionario, String data){
        pedidos.add(new Pedido(cliente, servico, funcionario, data));
    }

    //Cadastramentos <---
}
