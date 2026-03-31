package br.com.funeraria.util;

import br.com.funeraria.model.AtestadoDeObito;
import br.com.funeraria.model.Cliente;
import br.com.funeraria.model.Funcionario;
import br.com.funeraria.model.Servico;

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

    // Carregar lista do arquivo
    public List<Cliente> carregarCl() {
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

    public List<Funcionario> carregarFu() {
        List<Funcionario> funcionarios = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("funcionarios.txt"))) {

            String linha;
            while ((linha = br.readLine()) != null) {
                funcionarios.add(Funcionario.fromFileString(linha));
            }

        } catch (IOException e) {
            System.out.println("Arquivo ainda não existe.");
        }

        return funcionarios;
    }

    public List<Servico> carregarSe() {
        List<Servico> servicos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("servicos.txt"))) {

            String linha;
            while ((linha = br.readLine()) != null) {
                servicos.add(Servico.fromFileString(linha));
            }

        } catch (IOException e) {
            System.out.println("Arquivo ainda não existe.");
        }

        return servicos;
    }

    public List<AtestadoDeObito> carregarAt() {
        List<AtestadoDeObito> atestadoDeObitos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("atestados.txt"))) {

            String linha;
            while ((linha = br.readLine()) != null) {
                atestadoDeObitos.add(AtestadoDeObito.fromFileString(linha));
            }

        } catch (IOException e) {
            System.out.println("Arquivo ainda não existe.");
        }

        return atestadoDeObitos;
    }
}
