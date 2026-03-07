package com.cauahmachado.petadoptionsystem.service;

import com.cauahmachado.petadoptionsystem.exceptions.NomeInvalidoException;

import java.util.Scanner;

public class PetService {
    //validações

    public void cadastrar() throws NomeInvalidoException {
        Scanner scanner = new Scanner(System.in);
        String nome = scanner.nextLine();
        String sobrenome = scanner.nextLine();
        if (nome.isEmpty()){
            throw new NomeInvalidoException("Nome inválido");
        }
        if (sobrenome.isEmpty()){
            throw new NomeInvalidoException("Sobrenome inválido");
        }


        System.out.println("Usuário cadastrado com sucesso");
    }
}
