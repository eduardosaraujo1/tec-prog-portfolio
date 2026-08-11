package br.edu.fatecpg.passagem.model;

import java.util.ArrayList;

public class Aeroporto {

    private ArrayList<Voo> voos;

    public Aeroporto() {
        voos = new ArrayList<Voo>();
    }

    public Voo get(int idx) {
        return voos.get(idx);
    }

    public boolean add(Voo voo) {
        return voos.add(voo);
    }

    public Voo remove(int idx) {
        return voos.remove(idx);
    }

    public void exibirVoos() {
        for (Voo v : voos) {
            System.out.println(v);
        }
    }
}
