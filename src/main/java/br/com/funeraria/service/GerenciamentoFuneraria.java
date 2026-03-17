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
    public boolean consultarClientes(String nome, String cpf){
        boolean confirm = false;
        for (Cliente c: clientes){
            if (c.getNome().equalsIgnoreCase(nome) && c.getCpf().equalsIgnoreCase(cpf)){
                confirm = true;
            }
        }
        return confirm;
    }
    public boolean consultarFuncionarios(String nome, String cargo){
        boolean confirm = false;
        for (Funcionario f: funcionarios){
            if (f.getNome().equalsIgnoreCase(nome) && f.getCargo().equalsIgnoreCase(cargo)){
                confirm = true;
            }
        }
        return confirm;
    }
    public boolean consultarServicos(String descricao, double preco){
        boolean confirm = false;
        for (Servico s: servicos){
            if (s.getDescricao().equalsIgnoreCase(descricao) && s.getPreco()==preco){
                confirm = true;
            }
        }
        return confirm;
    }
    public void consultarPedidos(){
        boolean confirm = false;
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
