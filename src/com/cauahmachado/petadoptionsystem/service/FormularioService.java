package com.cauahmachado.petadoptionsystem.service;

import java.io.*;

public class FormularioService {

    public void exibirFormulario() {
        File file = new File("C:\\Users\\User\\IdeaProjects\\petAdoptionSystem\\src\\resources\\formulario.txt");
        try (FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader)){
            String linha;
            while ((linha = bufferedReader.readLine()) != null){
                System.out.println(linha);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
