package br.com.funeraria.service;

import br.com.funeraria.model.*;

import java.util.List;

public interface IGerenciamentoFuneraria {
    Cliente consultarClientes(String nome, String cpf);
    Funcionario consultarFuncionarios(String nome, String cargo);
    Servico consultarServicos(String descricao, double preco);
    List<Pedido> listarPedidos();

    void adicionarCliente(String nome, String telefone, String endereco, String cpf) throws ClienteJaExixteException;
    void adicionarFuncionario(String nome, String cargo) throws FuncionarioJaExiteException;
    void adicionarServico(String descricao, double preco) throws ServicoJaExisteExcepitino;
    void adicionarPedido(Cliente cliente, Servico servico, Funcionario funcionario, String data, AtestadoDeObito dadosFinado) throws PedidoJaExisteException;
    void adicionarAtestadoDeObito(String cpfFinado, String nome, String dataMorte,
                                  String horaMorte, double altura, String causaMorte) throws AtestadoJaExiteException;
}