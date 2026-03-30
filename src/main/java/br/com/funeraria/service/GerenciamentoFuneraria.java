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


    public List<Cliente> getClientes() {return clientes;}
    public List<Funcionario> getFuncionarios() {return funcionarios;}
    public List<Servico> getServicos() {return servicos;}
    public List<Pedido> getPedidos() {return pedidos;}
    public List<AtestadoDeObito> getAtestados() {return atestados;}

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
    public void adicionarCliente(String nome, String telefone, String endereco, String cpf) throws ClienteJaExixteException{
        for (Cliente c: clientes){
            if (c.getCpfCliente().equals(cpf)){
                throw new ClienteJaExixteException("O Cliente cadastrado já existe!");
            }
        }
        clientes.add(new Cliente(nome, telefone, endereco, cpf));
    }

    @Override
    public void adicionarFuncionario(String nome, String cargo) throws FuncionarioJaExiteException{
        for (Funcionario f: funcionarios){
            if (f.getNome().equalsIgnoreCase(nome) && f.getCargo().equalsIgnoreCase(cargo)){
                throw new FuncionarioJaExiteException("O Funcionario cadastrado já existe!");
            }
        }
        funcionarios.add(new Funcionario(nome, cargo));
    }

    @Override
    public void adicionarServico(String descricao, double preco) throws ServicoJaExisteExcepitino{
        for (Servico s: servicos){
            if (s.getDescricao().equalsIgnoreCase(descricao)){
                throw new ServicoJaExisteExcepitino("O Serviço cadastrado já existe!");
            }
        }
        servicos.add(new Servico(descricao, preco));
    }

    @Override
    public void adicionarPedido(Cliente cliente, Servico servico, Funcionario funcionario, String data, AtestadoDeObito dadosFinado) throws PedidoJaExisteException{

        Pedido novoPedido = new Pedido(cliente, servico, funcionario, data, dadosFinado);

        if (existePedido(novoPedido)){
            throw new PedidoJaExisteException("Esse pedido cadastrado já existe!");
        }
        pedidos.add(novoPedido);
    }

    @Override
    public void adicionarAtestadoDeObito(String cpfFinado, String nome, String dataMorte,
                                         String horaMorte, double altura, String causaMorte) throws AtestadoJaExiteException {
        for (AtestadoDeObito at: atestados){
            if (at.getCpfFinado().equalsIgnoreCase(cpfFinado)){
                throw new AtestadoJaExiteException("Esse Atestado de Obito já está cadastrado!");
            }
        }
        atestados.add(new AtestadoDeObito(cpfFinado, nome, dataMorte, horaMorte, altura, causaMorte));
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

    public boolean existePedido(Pedido novoPedido) {
        for (Pedido p : pedidos) {
            if (p.getCliente().getCpfCliente().equalsIgnoreCase(novoPedido.getCliente().getCpfCliente()) &&
                    p.getServico().getDescricao().equalsIgnoreCase(novoPedido.getServico().getDescricao()) &&
                    p.getFuncionario().getIdFuncionario() == novoPedido.getFuncionario().getIdFuncionario() &&
                    p.getData().equals(novoPedido.getData())) {
                return true;
            }
        }
        return false;
    }
}