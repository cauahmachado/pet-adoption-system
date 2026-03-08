package com.cauahmachado.petadoptionsystem.exceptions;

public class PesoInvalidoException extends RuntimeException {
    public PesoInvalidoException() {
        super("Peso Inválido");
    }

    public PesoInvalidoException(String message) {
        super(message);
    }
}
