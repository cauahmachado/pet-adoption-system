package com.cauahmachado.petadoptionsystem.repository;
import com.cauahmachado.petadoptionsystem.model.Pet;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PetRepository {

   public void salvar(Pet pet){

       LocalDateTime localDateTime = LocalDateTime.now();
       DateTimeFormatter formatacaoData = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm");
       String data = localDateTime.format(formatacaoData);
       String nomeArquivo = data + "-" + pet.getNome().toUpperCase() + pet.getSobrenome().toUpperCase() + ".TXT";
       String caminho = "C:\\Users\\User\\IdeaProjects\\petAdoptionSystem\\petsCadastrados\\" + nomeArquivo;
       try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminho))) {
           writer.write("1 - " + pet.getNome() + " " + pet.getSobrenome());
           writer.newLine();
           writer.write("2 - " + pet.getSexo());
           writer.newLine();
           writer.write("3 - " + pet.getTipo());
           writer.newLine();
           writer.write("4 - " + pet.getEndereco().getRua() + ", " + pet.getEndereco().getNumeroCasa() + ", " + pet.getEndereco().getCidade());
           writer.newLine();
           writer.write("5 - " + pet.getIdade());
           writer.newLine();
           writer.write("6 - " + pet.getPeso());
           writer.newLine();
           writer.write("7 - " + pet.getRaca());
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
   }
}
