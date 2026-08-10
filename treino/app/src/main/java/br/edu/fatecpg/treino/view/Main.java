package br.edu.fatecpg.treino.view;

import br.edu.fatecpg.treino.model.Aluno;
import br.edu.fatecpg.treino.model.TreinoOnline;
import br.edu.fatecpg.treino.model.TreinoPresencial;

public class Main {

    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("Ana", 9.5);
        Aluno aluno2 = new Aluno("Bruno", 8.0);
        Aluno aluno3 = new Aluno("Carla", 7.5);

        TreinoOnline treinoOnline = new TreinoOnline(
            1,
            60,
            "Carlos",
            "Java",
            "https://meet.google.com/abcd"
        );
        TreinoPresencial treinoPresencial = new TreinoPresencial(
            2,
            120,
            "Mariana",
            "Python",
            "Lab 04"
        );
        treinoOnline.addAluno(aluno1);
        treinoOnline.addAluno(aluno2);

        treinoPresencial.addAluno(aluno2);
        treinoPresencial.addAluno(aluno3);

        System.out.println(
            "Instrutor disponível: " + treinoOnline.verificarDisponibilidade()
        );
        treinoOnline.definirCargaHoraria(40);

        System.out.println(
            "Último treinamento: " +
                treinoPresencial.verificarUltimoTreinamento(aluno1)
        );
        treinoPresencial.setInstrutorDisponivel(false);
    }
}
