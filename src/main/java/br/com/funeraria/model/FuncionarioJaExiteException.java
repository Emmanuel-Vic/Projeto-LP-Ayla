package br.com.funeraria.model;

public class FuncionarioJaExiteException extends RuntimeException {
    public FuncionarioJaExiteException(String message) {
        super(message);
    }
}
