/*
 * [1]
 * Crie a interface "Funcionario" e as classes "Gerente", "Vendedor" e
 * "Faxineiro".
 * 
 * Crie métodos genéricos para todos e Métodos específicos exemplo:
 * 
 * Bater o Ponto
 * Fechar o Caixa
 * Realizar a Venda
 * Solicitar Material
 * 
 * Obs: use a linguagem java e siga as dicas sobre como criar classes. Faça a
 * relação de herança de acordo com a aula.
 */

package br.edu.fatecpg.atvheranca.ex1.view;

import br.edu.fatecpg.atvheranca.ex1.model.*;

public class Main {
    public static void main(String[] args) {
        Vendedor v = new Vendedor("Edivaldo", 3000);
        v.baterPonto();
        v.atenderCliente("José");
        v.baterPonto();
        System.out.println(v.getSalario());

        Faxineiro f = new Faxineiro("Fabricio");
        f.baterPonto();
        f.atenderCliente("Josivaldo");
        f.limparMesa(4);
        f.baterPonto();

        Gerente g = new Gerente("Genivaolvo", new IFuncionario[] { v, f });
        g.baterPonto();
        g.atenderCliente("Kleber");
        g.exibirSubordinados();
        g.baterPonto();
    }
}