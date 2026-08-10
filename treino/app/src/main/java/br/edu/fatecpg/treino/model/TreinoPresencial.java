package br.edu.fatecpg.treino.model;

public class TreinoPresencial extends Treino {

    private String local;

    public TreinoPresencial(
        final int id,
        final int cargaHoraria,
        final String nomeInstrutor,
        final String linguagemEnsinada,
        final String local
    ) {
        super(id, cargaHoraria, nomeInstrutor, linguagemEnsinada);
        this.local = local;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
