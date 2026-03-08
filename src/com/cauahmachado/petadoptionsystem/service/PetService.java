package com.cauahmachado.petadoptionsystem.service;

import com.cauahmachado.petadoptionsystem.exceptions.IdadeInvalidoException;
import com.cauahmachado.petadoptionsystem.exceptions.NomeInvalidoException;
import com.cauahmachado.petadoptionsystem.exceptions.PesoInvalidoException;
import com.cauahmachado.petadoptionsystem.exceptions.RacaInvalidaException;
import com.cauahmachado.petadoptionsystem.model.Endereco;
import com.cauahmachado.petadoptionsystem.model.Pet;
import com.cauahmachado.petadoptionsystem.model.TipoAnimal;
import com.cauahmachado.petadoptionsystem.model.TipoSexo;
import com.cauahmachado.petadoptionsystem.utils.Constantes;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PetService {
    //validações

    public Pet cadastrar() {
        FormularioService formularioService = new FormularioService();
        Endereco endereco = new Endereco();
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("^[a-zA-zÀ-ú\\s]+$");
        TipoSexo tipoSexo = null;
        TipoAnimal tipoAnimal = null;

        formularioService.exibirFormulario();

        System.out.println("Digite o nome do pet: ");
        String nome = scanner.nextLine();
        if (nome.isEmpty()) {
            throw new NomeInvalidoException("Nome inválido");
        }
        Matcher matcher = pattern.matcher(nome);
        if (!matcher.matches()) {
            throw new NomeInvalidoException("Nome não pode conter caracteres especiais");
        }

        System.out.println("Digite o sobre nome do pet: ");
        String sobrenome = scanner.nextLine();
        if (sobrenome.isEmpty()) {
            throw new NomeInvalidoException("Sobrenome inválido");
        }
        Matcher matcher1 = pattern.matcher(sobrenome);
        if (!matcher1.matches()) {
            throw new NomeInvalidoException("Sobrenome não pode conter caracteres especiais");
        }


        System.out.println("Selecione o número correspondente ao sexo do animal");
        System.out.println("1 -> Masculino");
        System.out.println("2 -> Feminino");
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
                System.out.println("Opção Invalida");
        }

        System.out.println("Selecione o número correspondente ao tipo do animal");
        System.out.println("1 - Cachorro");
        System.out.println("2- Gato");
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

        System.out.println("Digite a idade(aproximada) do pet em meses: ");
        String idadeString = scanner.nextLine();
        if (idadeString.isBlank()){
            idadeString = Constantes.NAO_INFORMADO;
        }else {
            idadeString = idadeString.replace(",", ".");
            double idade = Double.parseDouble(idadeString);
            idade = idade / 12;
            if (idade > 20) {
                throw new IdadeInvalidoException("Idade Inválida");
            }
            idadeString = String.valueOf(idade);
        }
        System.out.println("Digite o peso(aproximado) do pet: ");
        String pesoString = scanner.nextLine();
        if (pesoString.isBlank()) {
            pesoString = Constantes.NAO_INFORMADO;
        } else {
            pesoString = pesoString.replace(",", ".");
            double peso = Double.parseDouble(pesoString);
            if (peso > 60 || peso < 0.5) {
                throw new PesoInvalidoException("Peso Inválido");
            }
            pesoString = String.valueOf(peso);
        }

        System.out.println("Digite a raça do pet: ");
        String raca = scanner.nextLine();

        if (raca.isBlank()) {
            raca = Constantes.NAO_INFORMADO;
        } else {
            Matcher matcherraca = pattern.matcher(raca);
            if (!matcherraca.matches()) {
                throw new RacaInvalidaException("Raça Inválida");
            }
        }
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
        return pet;
    }
}
