package br.com.funeraria.model;

public class PedidoJaExisteException extends RuntimeException {
    public PedidoJaExisteException(String message) {
        super(message);
    }
}
