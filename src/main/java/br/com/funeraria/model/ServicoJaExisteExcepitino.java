package br.com.funeraria.model;

public class ServicoJaExisteExcepitino extends RuntimeException {
    public ServicoJaExisteExcepitino(String message) {
        super(message);
    }
}
