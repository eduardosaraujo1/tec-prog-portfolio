package br.edu.fatecpg.polimorfismo.ex2.view;

import br.edu.fatecpg.polimorfismo.ex2.model.*;;

public class Main {
    public static void main(String[] args) {
        Calculadora c = new Calculadora();
        int x = c.somar(2, 3); // 5
        int y = c.somar(5, 4, 3); // 12
        double z = c.somar(3.1, 5.33); // 8.43

        System.out.printf("int somar(int,int): %s\n"
                + "int somar(int,int,int): %s\n"
                + "double somar(double,double): %s\n", x, y, z);
    }
}

/*
 * 2. Sobrecarga de métodos
 * 
 * Enunciado:
 * Crie uma classe Calculadora que contenha três versões do método somar(). A
 * primeira versão deve receber dois parâmetros inteiros, a segunda deve receber
 * três parâmetros inteiros, e a terceira deve receber dois parâmetros do tipo
 * double.
 * ● Implemente as três versões do método somar() e teste chamando cada uma com
 * diferentes combinações de argumentos.
 * ● Discuta como a sobrecarga de métodos permite a criação de várias versões do
 * mesmo método com assinaturas diferentes.
 * 
 * Pergunta:
 * Descreva o mecanismo de sobrecarga de métodos e como ele difere da
 * sobrescrita em termos de polimorfismo.
 */