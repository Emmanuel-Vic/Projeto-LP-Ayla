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

    public Servico(){
        this("", 0.0);
    }

    public String getDescricao() {return descricao;}
    public double getPreco() {return preco;}
    public boolean isDisponivel() {return disponivel;}

    public void setPreco(double preco) {this.preco = preco;}
    public void setDescricao(String descricao) {this.descricao = descricao;}
    public void setDisponivel(boolean disponivel) {this.disponivel = disponivel;}

    public static Servico fromFileString(String linha) {
        String[] partes = linha.split(";");

        Servico servico = new Servico();
        servico.setDescricao(partes[0]);
        servico.setPreco(Double.parseDouble(partes[1]));

        return servico;
    }

    public String toString(){
        return "Serviço: " + descricao +
                "\nNo preço de: " + preco +
                "\nEstar disponível: " + disponivel;
    }
}
