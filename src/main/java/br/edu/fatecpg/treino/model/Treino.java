package br.edu.fatecpg.treino.model;

import java.util.ArrayList;

public class Treino {
    private int id;
    private String nomeInstrutor;
    private String linguagemEnsinada;
    private ArrayList<Aluno> alunos;

    public Treino(int id, String nomeInstrutor, String linguagemEnsinada) {
        this.id = id;
        this.nomeInstrutor = nomeInstrutor;
        this.linguagemEnsinada = linguagemEnsinada;
    }

    public int getId() {
        return id;
    }

    public String getNomeInstrutor() {
        return nomeInstrutor;
    }

    public void setNomeInstrutor(String nomeInstrutor) {
        this.nomeInstrutor = nomeInstrutor;
    }

    public String getLinguagemEnsinada() {
        return linguagemEnsinada;
    }

    public void setLinguagemEnsinada(String linguagemEnsinada) {
        this.linguagemEnsinada = linguagemEnsinada;
    }

    @Override
    public String toString() {
        return "Treino{" +
                "id=" + id +
                ", nomeInstrutor='" + nomeInstrutor + '\'' +
                ", linguagemEnsinada='" + linguagemEnsinada + '\'' +
                '}';
    }
}
