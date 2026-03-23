package br.com.funeraria.service;

import br.com.funeraria.model.*;

import java.util.ArrayList;
import java.util.List;

public class GerenciamentoFuneraria implements IGerenciamentoFuneraria {

    protected List<Cliente> clientes = new ArrayList<>();
    protected List<Funcionario> funcionarios = new ArrayList<>();
    protected List<Servico> servicos = new ArrayList<>();
    protected List<Pedido> pedidos = new ArrayList<>();
    protected List<AtestadoDeObito> atestados = new ArrayList<>();

    // Consultas
    @Override
    public Cliente consultarClientes(String nome, String cpf) {
        for (Cliente c : clientes) {
            if (c.getNomeCliente().equalsIgnoreCase(nome) && c.getCpfCliente().equalsIgnoreCase(cpf)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public Funcionario consultarFuncionarios(String nome, String cargo) {
        for (Funcionario f : funcionarios) {
            if (f.getNome().equalsIgnoreCase(nome) && f.getCargo().equalsIgnoreCase(cargo)) {
                return f;
            }
        }
        return null;
    }

    @Override
    public Servico consultarServicos(String descricao, double preco) {
        for (Servico s : servicos) {
            if (s.getDescricao().equalsIgnoreCase(descricao) && s.getPreco() == preco) {
                return s;
            }
        }
        return null;
    }

    @Override
    public List<Pedido> listarPedidos() {
        return pedidos;
    }

    // Cadastramentos
    @Override
    public void adicionarCliente(String nome, String telefone, String endereco, String cpf) {
        clientes.add(new Cliente(nome, telefone, endereco, cpf));
    }

    @Override
    public void adicionarFuncionario(String nome, String cargo) {
        funcionarios.add(new Funcionario(nome, cargo));
    }

    @Override
    public void adicionarServico(String descricao, double preco) {
        servicos.add(new Servico(descricao, preco));
    }
    public List<Servico> listarServicos() {
        return servicos;
    }

    @Override
    public void adicionarPedido(Cliente cliente, Servico servico, Funcionario funcionario, String data, AtestadoDeObito dadosFinado) {
        pedidos.add(new Pedido(cliente, servico, funcionario, data));
    }

    @Override
    public void adicionarAtestadoDeObito(String cpfFinado, String nome, String dataMorte,
                                         String horaMorte, double altura, String causaMorte) {
        atestados.add(new AtestadoDeObito(cpfFinado, nome, dataMorte, horaMorte, altura, causaMorte));
    }
}