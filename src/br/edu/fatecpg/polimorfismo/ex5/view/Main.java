package br.edu.fatecpg.polimorfismo.ex5.view;

import br.edu.fatecpg.polimorfismo.ex5.model.Conversor;

public class Main {

    public static void main(String[] args) {
        final Conversor c = new Conversor();
        System.out.printf(
                "40 graus celsius para Fahrenheit: %f\n"
                        + "60 quilômetros para milhas: %f\n"
                        + "String 'ola,mundo' para UPPERCASE: %s\n",
                c.converter(40d),
                c.converter(40f),
                c.converter("ola,mundo"));
    }
}

/*
 * 5. Sobrecarga de métodos em uma classe de conversão
 * 
 * Enunciado:
 * Implemente uma classe chamada Conversor que contenha três versões
 * sobrecarregadas do método converter():
 * ● A primeira versão deve converter uma temperatura de Celsius para
 * Fahrenheit.
 * ● A segunda versão deve converter um valor de quilômetros para milhas.
 * ● A terceira versão deve converter uma string para letras maiúsculas.
 * ● Teste todas as versões do método converter() chamando cada uma com os
 * parâmetros adequados.
 * 
 * Pergunta:
 * Explique como a sobrecarga de métodos permite implementar várias versões do
 * método converter(), mesmo com diferentes tipos de dados e funcionalidades.
 */