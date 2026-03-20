package br.com.funeraria.model;

public class ClienteJaExixteException extends RuntimeException {
    public ClienteJaExixteException(String message) {
        super(message);
    }
}
