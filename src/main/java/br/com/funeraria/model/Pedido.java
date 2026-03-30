package br.com.funeraria.model;

public class Pedido {
    private Cliente cliente;
    private Servico servico;
    private Funcionario funcionario;
    private String data;
    private AtestadoDeObito dadosFinado;

    public Pedido(Cliente cliente, Servico servico, Funcionario funcionario, String data, AtestadoDeObito dadosFinado){
        this.cliente = cliente;
        this.servico = servico;
        this.funcionario = funcionario;
        this.data = data;
        this.dadosFinado = dadosFinado;
    }

    public Cliente getCliente() {return cliente;}
    public Servico getServico() {return servico;}
    public Funcionario getFuncionario() {return funcionario;}
    public String getData() {return data;}
    public AtestadoDeObito getDadosFinado() {return dadosFinado;}


    public String toString(){
        return "\nO pedido foi feito pelo Cliente: "+cliente.getNomeCliente()+
                "\nFoi feito uma Servico descrito como: "+servico.getDescricao()+
                "\nE foi feito pelo Funcionario(a): "+funcionario.getNome()+"- "+funcionario.getCargo()+ " - na data " + data +
                "\nPara o finado cujo o atestado de Óbito é" + dadosFinado.toString();
    }
}
