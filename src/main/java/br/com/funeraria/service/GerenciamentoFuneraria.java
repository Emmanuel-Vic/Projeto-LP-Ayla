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

    public void consultarClientes(String nome, String cpf){
        for (Cliente c: clientes){
            if (c.getNome().equalsIgnoreCase(nome) && c.getCpf().equalsIgnoreCase(cpf)){
                System.out.println(c);
            }
        }
    }

    public void consultarFuncionarios(String nome, String idFuncionario){
        for (Funcionario f: funcionarios){
            if (f.getNome().equalsIgnoreCase(nome) && f.getIdFuncionario().equalsIgnoreCase(idFuncionario)){
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
}
