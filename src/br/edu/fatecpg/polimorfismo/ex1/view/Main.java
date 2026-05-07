package br.edu.fatecpg.polimorfismo.ex1.view;

import br.edu.fatecpg.polimorfismo.ex1.model.*;

public class Main {
    public static void main(String[] args) {
        Bicicleta b = new Bicicleta();
        Carro c = new Carro();
        Veiculo[] veiculos = { b, c };

        moverVeiculos(veiculos);
    }

    private static void moverVeiculos(Veiculo[] v) {
        for (Veiculo ve : v) {
            ve.mover();
        }
    }
}

/*
 * 1. Sobrescrita de métodos em uma hierarquia de veículos
 * 
 * Enunciado:
 * Implemente uma classe base chamada Veiculo que possua um método mover(). Crie
 * duas subclasses: Carro e Bicicleta, que sobrescrevam o método mover() com
 * comportamentos específicos.
 * ● A classe Carro deve imprimir "O carro está dirigindo" e a classe Bicicleta
 * deve imprimir "A bicicleta está pedalando".
 * 
 * Pergunta:
 * Explique como a sobrescrita de métodos permite comportamentos diferentes para
 * objetos da mesma hierarquia.
 */