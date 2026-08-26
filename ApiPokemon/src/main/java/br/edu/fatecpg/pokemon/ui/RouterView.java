package br.edu.fatecpg.pokemon.ui;

import br.edu.fatecpg.pokemon.data.PokemonRepository;
import java.util.Scanner;

public class RouterView implements View {

    private final Scanner scanner;
    private final PokemonRepository repository;

    public RouterView(Scanner scanner, PokemonRepository repository) {
        this.scanner = scanner;
        this.repository = repository;
    }

    @Override
    public void loop() {
        boolean running = true;

        while (running) {
            Console.clear();
            System.out.println("=== Pokemon API e Favoritos ===");
            System.out.println();
            System.out.println("[1] Listar Pokémons");
            System.out.println("[2] Gerenciar Favoritos");
            System.out.println("[0] Sair");
            System.out.print("> ");

            String input = scanner.nextLine().trim();

            switch (input) {
                case "1" -> new PokemonListView(scanner, repository).loop();
                case "2" -> new FavoritesView(scanner, repository).loop();
                case "0" -> running = false;
                default -> {
                    System.out.println("Opção inválida.");
                    System.out.println("[Enter] OK");
                    scanner.nextLine();
                }
            }
        }

        Console.clear();
    }
}
