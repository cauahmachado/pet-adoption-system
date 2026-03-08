package com.cauahmachado.petadoptionsystem.exceptions;

public class NomeInvalidoException extends RuntimeException{
    public NomeInvalidoException() {
        super("Nome invalido");
    }

    public NomeInvalidoException(String message) {
        super(message);
    }
}
