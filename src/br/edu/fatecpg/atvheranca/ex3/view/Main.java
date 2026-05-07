package br.edu.fatecpg.atvheranca.ex3.view;

import java.util.Scanner;

import br.edu.fatecpg.atvheranca.ex3.model.SistemaDeSeguranca;

/*
 * [3]
 * Interface Autenticavel
 * Crie uma interface chamada Autenticavel com os seguintes métodos:
 * 
 * login(String usuario, String senha): Verifica se o login e a senha estão
 * corretos.
 * logout(): Faz o logout do usuário.
 * 
 * Implemente essa interface na classe SistemaDeSeguranca. Nessa classe:
 * 
 * Defina os valores de um login e senha corretos, como "admin" e "1234".
 * No método login(), implemente a lógica para verificar se o usuário e senha
 * inseridos correspondem aos valores corretos.
 * Se o login for bem-sucedido, armazene um valor booleano que indica se o
 * usuário está autenticado ou não.
 * 
 * Tarefa: Crie uma classe de teste que peça ao usuário para inserir o nome de
 * usuário e senha. Se o login estiver correto, o sistema deverá exibir uma
 * mensagem de boas-vindas. Caso contrário, deverá pedir para tentar novamente
 * até acertar. O sistema também deve permitir fazer o logout.
*/
public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SistemaDeSeguranca sistema = new SistemaDeSeguranca();

        while (!sistema.autenticado()) {
            System.out.print("Usuário: ");
            String usuario = scanner.nextLine();

            System.out.print("Senha: ");
            String senha = scanner.nextLine();

            if (sistema.login(usuario, senha)) {
                System.out.printf("Bem-vindo, %s!", usuario);
            } else {
                System.out.println("Usuário ou senha incorretos. Tente novamente.\n");
            }
        }

        System.out.println("\nDigite 'q' para sair.");

        while (sistema.autenticado()) {
            String comando = scanner.nextLine();

            if (comando.equals("q")) {
                sistema.logout();
            } else {
                System.out.println("Valor inválido.");
            }
        }

        scanner.close();
    }
}
