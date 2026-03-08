package com.cauahmachado.petadoptionsystem.exceptions;

public class IdadeInvalidoException extends RuntimeException {

    public IdadeInvalidoException() {
        super("Idade Inválida");
    }

    public IdadeInvalidoException(String message) {
        super(message);
    }
}
