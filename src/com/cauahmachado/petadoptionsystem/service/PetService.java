package com.cauahmachado.petadoptionsystem.service;

import com.cauahmachado.petadoptionsystem.exceptions.IdadeInvalidoException;
import com.cauahmachado.petadoptionsystem.exceptions.NomeInvalidoException;
import com.cauahmachado.petadoptionsystem.exceptions.PesoInvalidoException;
import com.cauahmachado.petadoptionsystem.exceptions.RacaInvalidaException;
import com.cauahmachado.petadoptionsystem.model.Endereco;
import com.cauahmachado.petadoptionsystem.model.Pet;
import com.cauahmachado.petadoptionsystem.model.TipoAnimal;
import com.cauahmachado.petadoptionsystem.model.TipoSexo;
import com.cauahmachado.petadoptionsystem.repository.PetRepository;
import com.cauahmachado.petadoptionsystem.utils.Constantes;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PetService {
    public Pet cadastrar() {
        FormularioService formularioService = new FormularioService();
        List<String> perguntas = formularioService.lerFormulario();
        Endereco endereco = new Endereco();
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("^[a-zA-zÀ-ú\\s]+$");
        TipoSexo tipoSexo = null;
        TipoAnimal tipoAnimal = null;
        String nome = "";
        String sobrenome = "";
        String idadeString = "";
        String pesoString = "";
        String raca = "";


        System.out.println(perguntas.getFirst());
        do {
            try {
                System.out.println("Nome:");
                nome = scanner.nextLine();
                if (nome.isEmpty()) {
                    throw new NomeInvalidoException("Nome inválido");
                }
                Matcher matcher = pattern.matcher(nome);
                if (!matcher.matches()) {
                    throw new NomeInvalidoException("Nome não pode conter caracteres especiais");
                }
                break;
            } catch (NomeInvalidoException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } while (true);
        do {
            try {
                System.out.println("Sobrenome:");
                sobrenome = scanner.nextLine();
                if (sobrenome.isEmpty()) {
                    throw new NomeInvalidoException("Sobrenome inválido");
                }
                Matcher matcher1 = pattern.matcher(sobrenome);
                if (!matcher1.matches()) {
                    throw new NomeInvalidoException("Sobrenome não pode conter caracteres especiais");
                }
                break;
            } catch (NomeInvalidoException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } while (true);
        do {
            System.out.println(perguntas.get(1));
            System.out.println("1 -> Masculino");
            System.out.println("2 -> Feminino");
            try {
                int sexo = scanner.nextInt();
                scanner.nextLine();
                switch (sexo) {
                    case 1:
                        tipoSexo = TipoSexo.MASCULINO;
                        break;
                    case 2:
                        tipoSexo = TipoSexo.FEMININO;
                        break;
                    default:
                        System.out.println("Opção Inválida");
                }
            } catch (InputMismatchException e) {
                System.out.println("Digite apenas números!");
                scanner.nextLine();
            }
        } while (tipoSexo == null);

        do {
            System.out.println(perguntas.get(2));
            System.out.println("1 - Cachorro");
            System.out.println("2- Gato");
            try {
                int tipo = scanner.nextInt();
                scanner.nextLine();
                switch (tipo) {
                    case 1:
                        tipoAnimal = TipoAnimal.CACHORRO;
                        break;
                    case 2:
                        tipoAnimal = TipoAnimal.GATO;
                        break;
                    default:
                        System.out.println("Opção Invalida");
                }
            } catch (InputMismatchException e) {
                System.out.println("Digite apenas números!");
                scanner.nextLine();
            }
        } while (tipoAnimal == null);
        System.out.println(perguntas.get(3));
        System.out.println("Digite a cidade: ");
        String cidade = scanner.nextLine();
        System.out.println("Digite a rua: ");
        String rua = scanner.nextLine();
        System.out.println("Digite o numero da casa: ");
        String numeroCasa = scanner.nextLine();
        endereco.setCidade(cidade);
        endereco.setRua(rua);
        if (numeroCasa.isEmpty()) {
            numeroCasa = Constantes.NAO_INFORMADO;
        }
        endereco.setNumeroCasa(numeroCasa);


        do {
            try {
                System.out.println(perguntas.get(4));
                idadeString = scanner.nextLine();
                if (idadeString.isBlank()) {
                    idadeString = Constantes.NAO_INFORMADO;
                    break;
                }
                idadeString = idadeString.replace(",", ".");
                double idade = Double.parseDouble(idadeString);
                idade = idade / 12;
                if (idade > 20) {
                    throw new IdadeInvalidoException("Idade Inválida");
                }
                idadeString = String.format(Locale.US, "%.2f", idade);
                break;
            } catch (IdadeInvalidoException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Digite apenas números");
            }
        } while (true);

        do {
            try {
                System.out.println(perguntas.get(5));
                pesoString = scanner.nextLine();
                if (pesoString.isBlank()) {
                    pesoString = Constantes.NAO_INFORMADO;
                    break;
                }
                pesoString = pesoString.replace(",", ".");
                double peso = Double.parseDouble(pesoString);
                if (peso > 60 || peso < 0.5) {
                    throw new PesoInvalidoException("Peso Inválido");
                }
                pesoString = String.format(Locale.US, "%.2f", peso);
                break;
            } catch (PesoInvalidoException e) {
                System.out.println("Erro " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Digite apenas números");
            }
        } while (true);

        do {
            try {
                System.out.println(perguntas.get(6));
                raca = scanner.nextLine();
                if (raca.isBlank()) {
                    raca = Constantes.NAO_INFORMADO;
                    break;
                }
                Matcher matcherraca = pattern.matcher(raca);
                if (!matcherraca.matches()) {
                    throw new RacaInvalidaException("Raça Inválida");
                }
                break;
            } catch (RacaInvalidaException e) {
                System.out.println("Erro " + e.getMessage());
            }
        } while (true);


        System.out.println("Usuário cadastrado com sucesso");

        Pet pet = new Pet();
        pet.setNome(nome);
        pet.setSobrenome(sobrenome);
        pet.setTipo(tipoAnimal);
        pet.setSexo(tipoSexo);
        pet.setEndereco(endereco);
        pet.setIdade(idadeString);
        pet.setPeso(pesoString);
        pet.setRaca(raca);

        PetRepository petRepository = new PetRepository();
        petRepository.salvar(pet);

        return pet;
    }
}
