package br.edu.fatecpg.polimorfismo.ex2.model;

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
public class Calculadora {
    public int somar(int a, int b) {
        return a + b;
    }

    public int somar(int a, int b, int c) {
        return a + b + c;
    }

    public double somar(double a, double b) {
        return a + b;
    }
}
