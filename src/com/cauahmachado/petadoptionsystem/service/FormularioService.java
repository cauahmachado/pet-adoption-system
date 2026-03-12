package com.cauahmachado.petadoptionsystem.service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FormularioService {

    public List<String> lerFormulario() {
        List<String> perguntas = new ArrayList<>();
        File file = new File("C:\\Users\\User\\IdeaProjects\\petAdoptionSystem\\resources\\formulario.txt");
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                perguntas.add(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return perguntas;
    }
}
