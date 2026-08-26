package br.edu.fatecpg.pokemon.ui;

import br.edu.fatecpg.pokemon.data.PokemonRepository;
import br.edu.fatecpg.pokemon.data.model.Pokemon;
import br.edu.fatecpg.pokemon.domain.exceptions.PokeApiException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class FavoritesView implements View {

    private final Scanner scanner;
    private final PokemonRepository repository;

    private List<Pokemon> favorites = List.of(); // minimiza problemas de null (java deveria ser null-save)
    private int index = 0;

    public FavoritesView(Scanner scanner, PokemonRepository repository) {
        this.scanner = scanner;
        this.repository = repository;
    }

    @Override
    public void loop() {
        boolean running = true;
        reload();

        while (running) {
            Console.clear();
            System.out.println("=== Pokémons Favoritos ===");
            System.out.println();

            if (favorites.isEmpty()) {
                System.out.println(
                    "Você ainda não tem nenhum pokémon favoritado.\n"
                );
                System.out.println(
                    "[A] Adicionar pokémon   [V] Voltar ao menu"
                );
            } else {
                index = clamp(0, index, favorites.size() - 1);

                Pokemon current = favorites.get(index);
                System.out.println(
                    "Pokémon " + (index + 1) + " de " + favorites.size()
                );
                System.out.println();
                System.out.println("Nome:   " + current.getName());
                System.out.println("ID:     " + current.getId());
                System.out.println("Altura: " + current.getHeight());
                System.out.println("Peso:   " + current.getWeight());
                System.out.println();
                System.out.println(
                    "[P] Anterior   [N] Próximo   [R] Remover   [A] Adicionar   [W] Limpar tudo   [V] Voltar"
                );
            }

            System.out.print("> ");
            String input = scanner.nextLine().trim().toLowerCase();

            switch (input) {
                case "p" -> previous();
                case "n" -> next();
                case "r" -> removeCurrent();
                case "a" -> addNew();
                case "w" -> wipeAll();
                case "v" -> running = false;
                default -> invalid();
            }
        }
    }

    private void reload() {
        try {
            favorites = repository.getFavoritePokemons();
            index = clamp(0, index, favorites.size() - 1);
        } catch (SQLException e) {
            favorites = List.of();
            System.out.println("Erro ao carregar favoritos: " + e.getMessage());
            pause();
        }
    }

    private void next() {
        if (favorites.isEmpty()) {
            invalid();
            return;
        }
        if (index >= favorites.size() - 1) {
            System.out.println("Já está no último pokémon.");
            pause();
        }

        index++;
    }

    private void previous() {
        if (favorites.isEmpty()) {
            invalid();
            return;
        }

        if (index <= 0) {
            System.out.println("Já está no primeiro pokémon.");
            pause();
        }

        index--;
    }

    private void removeCurrent() {
        if (favorites.isEmpty()) {
            invalid();
            return;
        }

        Pokemon current = favorites.get(index);
        System.out.println();
        System.out.printf(
            "Tem certeza que deseja remover '%s' dos favoritos? (s/n) ",
            current.getName()
        );
        String confirm = scanner.nextLine().trim().toLowerCase();

        if (confirm.equals("s")) {
            try {
                repository.removeFavoritePokemon(current);
                System.out.println(
                    current.getName() + " removido com sucesso."
                );
            } catch (SQLException e) {
                System.out.println(
                    "Erro ao remover pokémon: " + e.getMessage()
                );
            }
            reload();
        }
        pause();
    }

    private void addNew() {
        System.out.println();
        System.out.print("Digite o nome do pokémon a adicionar: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Nome inválido.");
            pause();
            return;
        }

        try {
            repository.addFavoritePokemon(name.toLowerCase());
            System.out.println(
                "'" + name + "' adicionado aos favoritos com sucesso."
            );
            reload();

            // Fazer o pokemon recém-adicionado estar selecionado
            for (int i = 0; i < favorites.size(); i++) {
                if (favorites.get(i).getName().equalsIgnoreCase(name)) {
                    index = i;
                    break;
                }
            }
        } catch (PokeApiException e) {
            System.out.println(
                "Erro ao buscar pokémon na API: " + e.getMessage()
            );
            System.out.println(
                "Verifique se o nome está correto e tente novamente."
            );
        } catch (SQLException e) {
            System.out.println(
                "Erro ao salvar pokémon no banco de dados: " + e.getMessage()
            );
            System.out.println("Ele já pode estar na sua lista de favoritos.");
        }
        pause();
    }

    private void wipeAll() {
        System.out.println();
        System.out.print(
            "Tem certeza que deseja apagar TODOS os pokémons favoritos? (s/n) "
        );
        String confirm = scanner.nextLine().trim().toLowerCase();

        if (confirm.equals("s")) {
            try {
                repository.wipeFavoritePokemons();
                System.out.println(
                    "Todos os pokémons favoritos foram removidos."
                );
                index = 0;
            } catch (SQLException e) {
                System.out.println(
                    "Erro ao limpar favoritos: " + e.getMessage()
                );
            }
            reload();
        }
        pause();
    }

    private void invalid() {
        System.out.println("Opção inválida.\n");
        pause();
    }

    private void pause() {
        System.out.println("[Enter] OK");
        scanner.nextLine();
    }

    private int clamp(int min, int v, int max) {
        if (v < min) return min;
        if (v > max) return max;
        return v;
    }
}
