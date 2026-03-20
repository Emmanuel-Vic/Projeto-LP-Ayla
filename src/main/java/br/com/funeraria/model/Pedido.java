package br.com.funeraria.model;

public class Pedido {
    private Cliente cliente;
    private Servico servico;
    private Funcionario funcionario;
    private String data;

    public Pedido(Cliente cliente, Servico servico, Funcionario funcionario, String data){
        this.cliente = cliente;
        this.servico = servico;
        this.funcionario = funcionario;
        this.data = data;
    }

    public Pedido cadastrarPedido(Cliente c, Servico s, Funcionario f, String data){
        return new Pedido(c, s, f, data);
    }

    public String toString(){
        return "\nO pedido foi feito pelo Cliente: "+cliente.getNome()+
                "\nFoi feito uma Servico descrito como: "+servico.getDescricao()+
                "\nE foi feito pelo Funcionario(a): "+funcionario.getNome()+"- "+funcionario.getCargo()+ " - no dia " + this.data;
    }
}
