package br.com.funeraria.model;

public class Servico {
    private String descricao;
    private double preco;
    private boolean disponivel;

    public Servico(String descricao, double preco){
        this.descricao = descricao;
        this.preco = preco;
        this.disponivel = true;
    }

    public String getDescricao() {return descricao;}
    public double getPreco() {return preco;}
    public boolean isDisponivel() {return disponivel;}

    public void setPreco(double preco) {this.preco = preco;}
    public void setDescricao(String descricao) {this.descricao = descricao;}
    public void setDisponivel(boolean disponivel) {this.disponivel = disponivel;}

    public Servico adicionarServico(String descricao, double preco){
        return new Servico(descricao, preco);
    }
}
