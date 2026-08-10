package br.edu.fatecpg.treino.model;

import java.util.ArrayList;

public class Treino {

    private int id;
    private String nomeInstrutor;
    private boolean instrutorDisponivel;
    private String linguagemEnsinada;
    private int cargaHoraria;
    private ArrayList<Aluno> alunos;

    public Treino(
        int id,
        int cargaHoraria,
        String nomeInstrutor,
        String linguagemEnsinada
    ) {
        this.id = id;
        this.nomeInstrutor = nomeInstrutor;
        this.cargaHoraria = cargaHoraria;
        this.linguagemEnsinada = linguagemEnsinada;
        this.instrutorDisponivel = true;
        alunos = new ArrayList<Aluno>();
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

    public void setInstrutorDisponivel(boolean disponivel) {
        this.instrutorDisponivel = disponivel;
    }

    public void addAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    @Override
    public String toString() {
        return (
            "Treino{" +
            "id=" +
            id +
            '\'' +
            ", cargaHoraria=" +
            cargaHoraria +
            '\'' +
            ", nomeInstrutor='" +
            nomeInstrutor +
            '\'' +
            ", linguagemEnsinada='" +
            linguagemEnsinada +
            '\'' +
            '}'
        );
    }

    public boolean verificarDisponibilidade() {
        return instrutorDisponivel;
    }

    public void definirCargaHoraria(int horas) {
        cargaHoraria = horas;
    }

    public boolean verificarUltimoTreinamento(Aluno aluno) {
        for (Aluno a : alunos) {
            if (
                a.getNome().equals(aluno.getNome()) &&
                a.getNotaFinal() == aluno.getNotaFinal()
            ) {
                return cargaHoraria <= 80;
            }
        }

        return false;
    }

    public double calcularMediaAlunos() {
        return (
            alunos
                .stream()
                .mapToDouble(a -> a.getNotaFinal())
                .sum() / alunos.size()
        );
    }

    public boolean isInstrutorDisponivel() {
        return instrutorDisponivel;
    }
}
