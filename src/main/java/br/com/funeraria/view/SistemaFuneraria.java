package br.com.funeraria.view;

import br.com.funeraria.model.AtestadoJaExiteException;
import br.com.funeraria.model.ClienteJaExixteException;
import br.com.funeraria.model.FuncionarioJaExiteException;
import br.com.funeraria.model.ServicoJaExisteExcepitino;
import br.com.funeraria.service.GerenciamentoFuneraria;

import javax.swing.*;

public class SistemaFuneraria {
    public static void main(String[] args) {
        GerenciamentoFuneraria ger = new GerenciamentoFuneraria();
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
                    "\n7. Sair" +
                    "\n====================");
            if (inicio.equals("1")) {
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
                    JOptionPane.showMessageDialog(null,"O Atestado de Óbito cadastrado já existe");
                }
            } else if(inicio.equals("2")) {
                String nomeCliente = JOptionPane.showInputDialog(null, "Diegite o nome do Cliente");
                String telefone = JOptionPane.showInputDialog(null, "Digite o telefone do Cliente:");
                String endereco = JOptionPane.showInputDialog(null,"Digite o endereço deste cliente? (Rua/Av, Número, Bairro, Cidade e Estado)");
                String cpfCliente = JOptionPane.showInputDialog(null, "Digite o CPF do Cliente");
                try{
                    ger.adicionarCliente(nomeCliente, telefone, endereco,cpfCliente);
                    JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
                } catch (ClienteJaExixteException e){
                    JOptionPane.showMessageDialog(null,"O Cliente cadastrado já existe");
                }
            } else if(inicio.equals("3")){
                String descricao = JOptionPane.showInputDialog(null,"Como será o serviço oferecido? (Descrição do serviço):");
                double valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor do serviço:"));
                try{
                    ger.adicionarServico(descricao, valor);
                    JOptionPane.showMessageDialog(null, "Serviço cadastrado com sucesso!");
                } catch (ServicoJaExisteExcepitino e){
                    JOptionPane.showMessageDialog(null,"O Serviço cadastrado já existe");
                }
            } else if(inicio.equals("4")){
                String nome = JOptionPane.showInputDialog(null, "Digite o nome do funcionário");
                String cargo = JOptionPane.showInputDialog(null, "Digite o cargo do funcionário");
                try{
                    ger.adicionarFuncionario(nome, cargo);
                    JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso");
                }catch (FuncionarioJaExiteException e){
                    JOptionPane.showMessageDialog(null,"O Funcionario cadastrado já existe");
                }
            } else if(inicio.equals("5")){
                //VOU FAZER!
            } else if(inicio.equals("6")){
                //VOU FAZER!
            } else if(inicio.equals("7")){
                continuar = false;
            } else{
                JOptionPane.showMessageDialog(null,"Opção inválida");
            }
        }
    }
}
