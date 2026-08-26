package br.edu.fatecpg.pokemon.ui;

import br.edu.fatecpg.pokemon.data.PokemonRepository;
import java.util.Scanner;

public class PokemonListView implements View {

    private final Scanner scanner;
    private final PokemonRepository repository;
    private final int POKEMON_COUNT = 15;

    public PokemonListView(Scanner scanner, PokemonRepository repository) {
        this.scanner = scanner;
        this.repository = repository;
    }

    @Override
    public void loop() {
        // Exibir uma lista de 15 pokemons
        // Dar opções para navegar (próximo ou anterior)
        // Dar opção para voltar ao menu anterior.
        throw new UnsupportedOperationException("Unimplemented method 'loop'");
    }
}
