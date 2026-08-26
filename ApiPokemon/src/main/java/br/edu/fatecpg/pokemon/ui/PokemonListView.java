package br.edu.fatecpg.pokemon.ui;

import br.edu.fatecpg.pokemon.data.PokemonRepository;
import br.edu.fatecpg.pokemon.domain.exceptions.PokeApiException;
import java.util.List;
import java.util.Scanner;

public class PokemonListView implements View {

    private final Scanner scanner;
    private final PokemonRepository repository;
    private final int POKEMON_COUNT = 15;

    private int page = 0;

    public PokemonListView(Scanner scanner, PokemonRepository repository) {
        this.scanner = scanner;
        this.repository = repository;
    }

    @Override
    public void loop() {
        boolean running = true;

        while (running) {
            Console.clear();
            List<String> pokemons;

            try {
                pokemons = repository.getPokemonList(
                    POKEMON_COUNT,
                    page * POKEMON_COUNT
                );
            } catch (PokeApiException e) {
                running = handleFetchError(e);
                continue;
            }

            System.out.println(
                "=== Lista de Pokémons - Página " + (page + 1) + ") ===\n"
            );

            if (pokemons.isEmpty()) {
                System.out.println("Nenhum pokémon encontrado nesta página.");
            } else {
                int index = page * POKEMON_COUNT + 1;
                for (String name : pokemons) {
                    System.out.printf("(%d) %s%n", index++, name);
                }
            }

            System.out.print(
                "\n[N] Próxima página   [P] Página anterior   [V] Voltar ao menu\n> "
            );
            String input = scanner.nextLine().trim();

            switch (input.toLowerCase()) {
                case "n" -> nextPage(pokemons);
                case "p" -> previousPage();
                case "v" -> running = false;
                default -> invalid();
            }
        }
    }

    private void nextPage(List<String> pokemons) {
        if (pokemons.size() < POKEMON_COUNT) {
            System.out.println("Você já está na última página disponível.");
            pause();
        } else {
            page++;
        }
    }

    private void previousPage() {
        if (page > 0) {
            page--;
        } else {
            System.out.println("Você já está na primeira página.");
            pause();
        }
    }

    private void pause() {
        System.out.print("[Enter] OK");
        scanner.nextLine();
    }

    private void invalid() {
        System.out.println("Opção inválida.\n");
        pause();
    }

    private boolean handleFetchError(PokeApiException e) {
        System.out.println(
            "Erro ao buscar lista de pokémons: " + e.getMessage()
        );
        System.out.println(
            "Verifique sua conexão com a internet e tente novamente."
        );
        System.out.println();
        System.out.print("[Enter] Tentar novamente   [V] Voltar > ");

        String input = scanner.nextLine().trim();

        return !input.equalsIgnoreCase("v");
    }
}
