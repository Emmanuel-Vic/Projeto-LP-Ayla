package br.com.funeraria.model;

public class AtestadoDeObito {
    private String cpfFinado;
    private String nomeFinado;
    private String dataMorte;
    private String horaMorte;
    private double altura;
    private String causaMorte;

    public AtestadoDeObito (String cpfFinado, String nome, String dataMorte,
                          String horaMorte, double altura, String causaMorte){
        this.cpfFinado = cpfFinado;
        this.nomeFinado = nome;
        this.dataMorte = dataMorte;
        this.horaMorte = horaMorte;
        this.altura = altura;
        this.causaMorte = causaMorte;
    }

    public String getCpfFinado() {
        return cpfFinado;
    }
    public void setCpfFinado(String cpfFinado) {
        this.cpfFinado = cpfFinado;
    }
    public String getNome() {
        return nomeFinado;
    }
    public void setNome(String nome) {
        this.nomeFinado = nome;
    }
    public String getDataMorte() {
        return dataMorte;
    }
    public void setDataMorte(String dataMorte) {
        this.dataMorte = dataMorte;
    }
    public String getHoraMorte() {
        return horaMorte;
    }
    public void setHoraMorte(String horaMorte) {
        this.horaMorte = horaMorte;
    }
    public double getAltura() {
        return altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }
    public String getCausaMorte() {
        return causaMorte;
    }
    public void setCausaMorte(String causaMorte) {
        this.causaMorte = causaMorte;
    }

    public AtestadoDeObito(){
        this("", "", "", "", 0.0,"");
    }

    public static AtestadoDeObito fromFileString(String linha) {
        String[] partes = linha.split(";");

        AtestadoDeObito atestadoDeObito = new AtestadoDeObito();
        atestadoDeObito.setCpfFinado(partes[0]);
        atestadoDeObito.setNome(partes[1]);
        atestadoDeObito.setDataMorte(partes[2]);
        atestadoDeObito.setHoraMorte(partes[3]);
        atestadoDeObito.setAltura(Double.parseDouble(partes[4]));
        atestadoDeObito.setCausaMorte(partes[5]);

        return atestadoDeObito;
    }

    @Override
    public String toString() {
        return "Atestado de Óbito do finado: " + nomeFinado  +
                "\nCPF: "+ cpfFinado  +
                "\nVeio a óbito na data " + dataMorte  + "às " + horaMorte +
                "\nAltura: " + altura + "m de altura" +
                "\nCausa da Morte:" + causaMorte;
    }
}
