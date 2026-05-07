package br.edu.fatecpg.polimorfismo.ex3.view;

import br.edu.fatecpg.polimorfismo.ex3.model.*;

public class Main {
    public static void main(String[] args) {
        Produto p1 = new Produto("Laptop");
        Produto p2 = new Produto("Mouse", 59.99);
        Produto p3 = new Produto("Monitor", 59.99, 40);

        // Olha o overloading aqui: println recebe String, int, double, objeto e mais
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }
}

/*
 * 3. Sobrecarga de construtores
 * 
 * Enunciado:
 * Crie uma classe chamada Produto com três construtores sobrecarregados:
 * ● O primeiro deve receber um nome do produto (String).
 * ● O segundo deve receber um nome e um preço (double).
 * ● O terceiro deve receber um nome, um preço e uma quantidade em estoque
 * (int).
 * ● Instancie objetos da classe Produto utilizando cada um dos construtores e
 * imprima as informações dos produtos.
 * 
 * Pergunta:
 * Discuta como a sobrecarga de construtores facilita a criação de objetos com
 * diferentes conjuntos de informações, permitindo flexibilidade na instânciação
 * de objetos.
 */