package com.cauahmachado.petadoptionsystem.exceptions;

public class RacaInvalidaException extends RuntimeException {
    public RacaInvalidaException() {
        super("Raça Inválida");
    }

    public RacaInvalidaException(String message) {
        super(message);
    }
}
