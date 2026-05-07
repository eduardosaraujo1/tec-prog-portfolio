package br.edu.fatecpg.polimorfismo.ex5.model;

public class Conversor {
    public double converter(double celsius) {
        return 32 + celsius * 9 / 5;
    }

    public double converter(float km) {
        return 0.621371 * km;
    }

    public String converter(String texto) {
        return texto.toUpperCase();
    }
}
