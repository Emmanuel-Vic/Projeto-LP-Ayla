package br.com.funeraria.model;

public class PedidoJaExisteException extends Exception {
    public PedidoJaExisteException(String message) {
        super(message);
    }
}
