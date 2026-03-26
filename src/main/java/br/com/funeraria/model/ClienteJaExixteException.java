package br.com.funeraria.model;

public class ClienteJaExixteException extends Exception {
    public ClienteJaExixteException(String message) {
        super(message);
    }
}
