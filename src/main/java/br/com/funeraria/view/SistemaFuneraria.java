package br.com.funeraria.view;

import br.com.funeraria.model.*;
import br.com.funeraria.service.GerenciamentoFuneraria;
import br.com.funeraria.util.ArquivoUtils;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class SistemaFuneraria {
    public static void main(String[] args) {
        GerenciamentoFuneraria ger = new GerenciamentoFuneraria();
        List<Cliente> clientesArquivo = new ArquivoUtils().carregar();

        for (Cliente c : clientesArquivo) {
            // Adiciona na lista interna do gerenciador
            if (ger.validarCPFCliente(c.getCpfCliente()) == null) {
                ger.getClientes().add(c);
            }
        }
        boolean continuar = true;
        while (continuar) {
            String inicio = JOptionPane.showInputDialog(null,  "====================" +
                    "\nDigite uma Opção:" +
                    "\n1. Cadastrar Atestado de Óbito" +
                    "\n2. Cadastrar Cliente" +
                    "\n3. Cadastrar Serviço" +
                    "\n4. Cadastrar Funcionário" +
                    "\n5. Buscar" +
                    "\n6. Novo pedido" +
                    "\n7. Listar Clientes" +
                    "\n8. Sair e Salvar" +
                    "\n====================");
            if (inicio == null) {
                continuar = false;
                JOptionPane.showMessageDialog(null, "Saindo do sistema...");
            } else if (inicio.equals("1")) {
                String cpfFinado = JOptionPane.showInputDialog(null, "Digite o CPF do Finado: ");
                String nomeFinado =  JOptionPane.showInputDialog(null, "Digite o nome do Finado: ");
                String dataMorte = JOptionPane.showInputDialog(null, "Digite a data da Morte");
                String horaMorte = JOptionPane.showInputDialog(null, "Digite a hora da morte");
                double altura = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite a altura do defunto:"));
                String causaMorte = JOptionPane.showInputDialog(null, "Digite a Cuasa da Morte:");
                try{
                    ger.adicionarAtestadoDeObito(cpfFinado, nomeFinado, dataMorte, horaMorte, altura, causaMorte);
                    JOptionPane.showMessageDialog(null, "Atestado de Óbito cadastrado com sucesso!");
                } catch (AtestadoJaExiteException e){
                    JOptionPane.showMessageDialog(null,e.getMessage());
                }
            } else if(inicio.equals("2")) {
                String nomeCliente = JOptionPane.showInputDialog(null, "Diegite o nome do Cliente");
                String telefone = JOptionPane.showInputDialog(null, "Digite o telefone do Cliente:");
                String endereco = JOptionPane.showInputDialog(null,"Digite o endereço deste cliente? (Rua/Av, Número, Bairro, Cidade e Estado)");
                String cpfCliente = JOptionPane.showInputDialog(null, "Digite o CPF do Cliente");
                try{
                    ger.adicionarCliente(nomeCliente, telefone, endereco,cpfCliente);
                    ArquivoUtils.adicionarLinha("clientes.txt",
                            nomeCliente + ";" + telefone + ";" + endereco + ";" + cpfCliente);
                    JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
                } catch (ClienteJaExixteException e){
                    JOptionPane.showMessageDialog(null,e.getMessage());
                }
            } else if(inicio.equals("3")){
                String descricao = JOptionPane.showInputDialog(null,"Como será o serviço oferecido? (Descrição do serviço):");
                double valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor do serviço:"));
                try{
                    ger.adicionarServico(descricao, valor);
                    JOptionPane.showMessageDialog(null, "Serviço cadastrado com sucesso!");
                } catch (ServicoJaExisteExcepitino e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            } else if(inicio.equals("4")){
                String nome = JOptionPane.showInputDialog(null, "Digite o nome do funcionário");
                String cargo = JOptionPane.showInputDialog(null, "Digite o cargo do funcionário");
                try{
                    ger.adicionarFuncionario(nome, cargo);
                    JOptionPane.showMessageDialog(null, "Funcionário"
                            // + id do funcionario para que o operador do sistema saiba qual o id dos funcionários
                            +"cadastrado com sucesso");
                }catch (FuncionarioJaExiteException e){
                    JOptionPane.showMessageDialog(null,e.getMessage());
                }
            } else if(inicio.equals("5")){
                boolean buscas = true;
                while (buscas) {
                    String busca = JOptionPane.showInputDialog(null, "====================" +
                            "\nDigite uma Opção:" +
                            "\n1. Consultar Cliente" +
                            "\n2. Consultar Funcionário" +
                            "\n3. Consultar Serviço" +
                            "\n4. Sair da busca" +
                            "\n5. Sair do sistema"+
                            "\n====================");
                    if (busca.equals("1")) {
                        String nome = JOptionPane.showInputDialog(null, "Digite o nome do Cliente que você deseja buscar:");
                        String cpf = JOptionPane.showInputDialog(null, "Digite o cpf do Cliente que você deseja buscar:");
                        JOptionPane.showMessageDialog( null, ger.consultarClientes(nome, cpf));
                    } else if (busca.equals("2")) {
                        String nome = JOptionPane.showInputDialog(null, "Digite o nome do Funcionário que você deseja buscar:");
                        String cargo = JOptionPane.showInputDialog(null, "Digite o cargo do Funcionário que você deseja buscar:");
                        JOptionPane.showMessageDialog( null, ger.consultarFuncionarios(nome, cargo));
                    } else if (busca.equals("3")) {
                        String descricao = JOptionPane.showInputDialog(null, "Digite o Serviço que você deseja buscar:");
                        double preco = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o preço do Serviço que você deseja buscar:"));
                        JOptionPane.showMessageDialog( null, ger.consultarServicos(descricao, preco));
                    } else if (busca.equals("4")) {
                        buscas = false;
                    } else if(busca.equals("5")){
                        buscas = false;
                        continuar = false;
                    } else{
                        JOptionPane.showMessageDialog(null,"Opção inválida");
                    }
                }
            } else if(inicio.equals("6")){
                String cpfCliente = JOptionPane.showInputDialog(null, "Digite o CPF do Cliente");
                Cliente cpfEscolhido = ger.validarCPFCliente(cpfCliente);
                if (cpfEscolhido != null){
                    String descricao =  JOptionPane.showInputDialog(null, "Digite o Serviço");
                    Servico servEscolhido = ger.validarDescriServico(descricao);
                    if (servEscolhido != null){
                        int idfuncionario = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o id do funcionário"));
                        Funcionario funcEscolhido = ger.validarIdFuncionario(idfuncionario);
                        if (funcEscolhido != null){
                            String dataHoje = JOptionPane.showInputDialog(null, "Digite a data de hoje");
                            String cpfFinado = JOptionPane.showInputDialog(null, "Digite o CPF do Finado");
                            AtestadoDeObito atestadoEscolhi = ger.validarAtestadoObito(cpfFinado);
                            if (atestadoEscolhi != null){
                                try {
                                    ger.adicionarPedido(cpfEscolhido, servEscolhido, funcEscolhido, dataHoje, atestadoEscolhi);
                                    JOptionPane.showMessageDialog(null, "Pedido adicionado com sucesso!");
                                } catch (PedidoJaExisteException e){
                                    JOptionPane.showMessageDialog(null, e.getMessage());
                                }
                            } else{
                                JOptionPane.showMessageDialog(null, "CPF do finado não localizado!");
                            }
                        } else{
                            JOptionPane.showMessageDialog(null, "Funcionario não localizado!");
                        }
                    } else{
                        JOptionPane.showMessageDialog(null, "Serviço não localizado!");
                    }
                } else{
                    JOptionPane.showMessageDialog(null, "Esse CPF não foi localizado no registro!");
                }
            } else if(inicio.equals("7")){
                List<Cliente> lista = ger.getClientes();

                String resultado = "";
                for (Cliente c : lista) {
                    resultado += c.getNomeCliente() + " - " + c.getCpfCliente() + "\n";
                }

                JOptionPane.showMessageDialog(null, resultado);
            }  else if(inicio.equals("8")) {
                List<String> linhas = new ArrayList<>();

                for (Cliente c : ger.getClientes()) {
                    linhas.add(
                            c.getNomeCliente() + ";" +
                                    c.getTelefone() + ";" +
                                    c.getEndereco() + ";" +
                                    c.getCpfCliente()
                    );
                }

                ArquivoUtils.escreverArquivo("clientes.txt", linhas);
                continuar = false;
            } else{
                JOptionPane.showMessageDialog(null,"Opção inválida");
            }
        }
    }
}
