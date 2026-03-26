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

    public List<Servico> listarServicos() {
        return servicos;
    }

    @Override
    public List<Pedido> listarPedidos() {
        return pedidos;
    }

    // Cadastramentos
    @Override
    public void adicionarCliente(String nome, String telefone, String endereco, String cpf) throws ClienteJaExixteException{
        clientes.add(new Cliente(nome, telefone, endereco, cpf));
        throw new ClienteJaExixteException("O Cliente cadastrado já existe!");
    }

    @Override
    public void adicionarFuncionario(String nome, String cargo) throws FuncionarioJaExiteException{
        funcionarios.add(new Funcionario(nome, cargo));
        throw new FuncionarioJaExiteException("O Funcionario cadastrado já existe!");
    }

    @Override
    public void adicionarServico(String descricao, double preco) throws ServicoJaExisteExcepitino{
        servicos.add(new Servico(descricao, preco));
        throw new ServicoJaExisteExcepitino("O Serviço cadastrado já existe!");
    }

    @Override
    public void adicionarPedido(Cliente cliente, Servico servico, Funcionario funcionario, String data, AtestadoDeObito dadosFinado) throws PedidoJaExisteException{
        pedidos.add(new Pedido(cliente, servico, funcionario, data));
        throw new PedidoJaExisteException("Esse pedido cadastrado já existe!");
    }

    @Override
    public void adicionarAtestadoDeObito(String cpfFinado, String nome, String dataMorte,
                                         String horaMorte, double altura, String causaMorte) throws AtestadoJaExiteException {
        atestados.add(new AtestadoDeObito(cpfFinado, nome, dataMorte, horaMorte, altura, causaMorte));
        throw new AtestadoJaExiteException("Esse Atestado de Obito já está cadastrado!");
    }


    //Validamento de atributos

    public Cliente validarCPFCliente(String cpf){
        for (Cliente c: this.clientes){
            if (c.getCpfCliente().equals(cpf)){
                return c;
            }
        }
        return null;
    }

    public Servico validarDescriServico(String descri){
        for (Servico s: this.servicos){
            if (s.getDescricao().equals(descri)){
                return s;
            }
        }
        return null;
    }

    public Funcionario validarIdFuncionario(int id){
        for (Funcionario f: this.funcionarios){
            if (f.getIdFuncionario() == id){
                return f;
            }
        }
        return null;
    }

    public AtestadoDeObito validarAtestadoObito(String cpfObito){
        for (AtestadoDeObito a: this.atestados){
            if (a.getCpfFinado().equals(cpfObito)){
                return a;
            }
        }
        return null;
    }
}