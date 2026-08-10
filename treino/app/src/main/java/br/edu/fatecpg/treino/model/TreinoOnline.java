package br.edu.fatecpg.treino.model;

public class TreinoOnline extends Treino {

    private String linkAcesso;

    public TreinoOnline(
        final int id,
        final int cargaHoraria,
        final String nomeInstrutor,
        final String linguagemEnsinada,
        final String linkAcesso
    ) {
        super(id, cargaHoraria, nomeInstrutor, linguagemEnsinada);
        this.linkAcesso = linkAcesso;
    }

    public String getLinkAcesso() {
        return linkAcesso;
    }

    public void setLinkAcesso(final String linkAcesso) {
        this.linkAcesso = linkAcesso;
    }
}
