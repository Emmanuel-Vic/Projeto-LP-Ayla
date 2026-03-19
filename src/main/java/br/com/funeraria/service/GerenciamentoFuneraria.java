package br.com.funeraria.service;

import br.com.funeraria.model.Cliente;
import br.com.funeraria.model.Funcionario;
import br.com.funeraria.model.Pedido;
import br.com.funeraria.model.Servico;

import java.util.ArrayList;
import java.util.List;

public class GerenciamentoFuneraria implements IGerenciamentoFuneraria{

    List<Cliente> clientes = new ArrayList<>();
    List<Funcionario> funcionarios = new ArrayList<>();
    List<Servico> servicos = new ArrayList<>();
    List<Pedido> pedidos = new ArrayList<>();


    //Consultas --->
    public Cliente consultarClientes(String nome, String cpf){
        Cliente cliente = null;
        for (Cliente c: clientes){
            if (c.getNome().equalsIgnoreCase(nome) && c.getCpf().equalsIgnoreCase(cpf)){
                cliente = c;
            }
        }
        return cliente;
    }
    public Funcionario consultarFuncionarios(String nome, String cargo){
        Funcionario funcionario= null;
        for (Funcionario f: funcionarios){
            if (f.getNome().equalsIgnoreCase(nome) && f.getCargo().equalsIgnoreCase(cargo)){
                funcionario = f;
            }
        }
        return funcionario;
    }
    public Servico consultarServicos(String descricao, double preco){
        Servico servico = null;
        for (Servico s: servicos){
            if (s.getDescricao().equalsIgnoreCase(descricao) && s.getPreco()==preco){
                servico = s;
            }
        }
        return servico;
    }
    public List<Pedido> listarPedidos(){
        for (Pedido p: pedidos){
            System.out.println(p);
        }
        return pedidos;
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
