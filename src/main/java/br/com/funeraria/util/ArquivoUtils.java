package br.com.funeraria.util;

import br.com.funeraria.model.Cliente;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArquivoUtils {

    // Escrever no arquivo
    public static void escreverArquivo(String caminho, List<String> conteudo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminho))) {

            for (String linha : conteudo) {
                bw.write(linha);
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Erro ao escrever arquivo: " + e.getMessage());
        }
    }

    // Adicionar conteúdo ao arquivo
    public static void adicionarLinha(String caminho, String linha) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminho, true))) {

            bw.write(linha);
            bw.newLine();

        } catch (IOException e) {
            System.out.println("Erro ao adicionar linha: " + e.getMessage());
        }
    }

    // Carregar lista do arquivo
    public List<Cliente> carregar() {
        List<Cliente> clientes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("clientes.txt"))) {

            String linha;
            while ((linha = br.readLine()) != null) {
                clientes.add(Cliente.fromFileString(linha));
            }

        } catch (IOException e) {
            System.out.println("Arquivo ainda não existe.");
        }

        return clientes;
    }
}
