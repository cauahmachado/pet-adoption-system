package com.cauahmachado.petadoptionsystem.ui;

import com.cauahmachado.petadoptionsystem.service.PetService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        int resposta = 0;
        PetService petService = new PetService();
        do {
            System.out.println("1. Cadastrar um novo pet\n" +
                    "2. Alterar os dados do pet cadastrado\n" +
                    "3. Deletar um pet cadastrado\n" +
                    "4. Listar todos os pets cadastrados\n" +
                    "5. Listar pets por algum critério (idade, nome, raça)\n" +
                    "6. Sair");
            try {
                resposta = scanner.nextInt();
            } catch (InputMismatchException erro1) {
                System.err.println("Não é permitido inserir letras, informe apenas números inteiros!");
                scanner.nextLine();
            }
            switch (resposta) {
                case 1:
                    try {
                        petService.cadastrar();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    //metodo de alterar dados
                    break;
                case 3:
                    //metodo de deletar pet
                    break;
                case 4:
                    //metodo listar pets
                    break;
                case 5:
                    //metodo listar pets por criterio
                    break;
                default:
                    System.out.println("Número inválido, digite novamente");
            }

        } while (resposta != 6);

    }
}
