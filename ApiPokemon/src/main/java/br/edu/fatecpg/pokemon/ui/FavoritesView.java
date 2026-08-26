package br.edu.fatecpg.pokemon.ui;

import br.edu.fatecpg.pokemon.data.PokemonRepository;
import java.util.Scanner;

public class FavoritesView implements View {

    private final Scanner scanner;
    private final PokemonRepository repository;

    public FavoritesView(Scanner scanner, PokemonRepository repository) {
        this.scanner = scanner;
        this.repository = repository;
    }

    @Override
    public void loop() {
        // Pegar lista de pokemons favoritados e guardar no estado interno
        // Exibir um pokemon por vez, permitindo navegar para esquerda e direita
        // Mostrar página atual e a quantidade de páginas (literalmente array.length())
        // Para o pokemon atual, permitir operações de remover (adicionar diálogo de confirmação))
        // Por fim, adicionar opção de adicionar um novo pokemon a partir do nome (literalmente chamada do método correspondente em PokemonRepository)
        throw new UnsupportedOperationException("Unimplemented method 'loop'");
    }
}
