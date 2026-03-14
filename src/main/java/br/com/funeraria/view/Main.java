package br.com.funeraria.view;

import br.com.funeraria.model.Cliente;
import br.com.funeraria.model.Funcionario;
import br.com.funeraria.model.Pedido;
import br.com.funeraria.model.Servico;

public class Main {
    public static void main(String [] args){
        Cliente c1 = new Cliente("Pedro Costa", "(99) 99999-9999", "Rio Tinto","999.999.999-99");
        Funcionario f1 = new Funcionario("Mayara", "Coveiro(a)", "1111111111");
        Servico s1 = new Servico("Juze morreu e tem que ser enterrado de algum jeito", 2);
        Pedido p1 = new Pedido(c1, s1, f1, "14/03/2026");
        System.out.println(p1);
    }
}
