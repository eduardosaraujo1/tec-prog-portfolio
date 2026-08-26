package br.edu.fatecpg.pokemon.ui;

import java.util.Scanner;

public class RouterView implements View {

    private final Scanner scanner;

    public RouterView(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void loop() {
        // Em um laço de repetição, permitir escolha entre Sair, Listar pokemons e Gerenciar Favoritos.
        // Listar Pokemons deve usar uma instância de PokemonListView, chamar sua função .loop()
    }
}
