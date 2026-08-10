package br.edu.fatecpg.treino.model;

public class Aluno {

    private String nome;
    private double notaFinal;

    public Aluno(String nome, double notaFinal) {
        this.nome = nome;
        this.notaFinal = notaFinal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }

    @Override
    public String toString() {
        return (
            "Aluno{" + "nome='" + nome + "', " + "notaFinal=" + notaFinal + "}"
        );
    }
}
