package br.edu.fatecpg.pokemon;

import br.edu.fatecpg.pokemon.data.PokemonRepository;
import br.edu.fatecpg.pokemon.data.service.PokeApiService;
import br.edu.fatecpg.pokemon.data.service.PostgresConnection;
import br.edu.fatecpg.pokemon.ui.RouterView;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // UC001 - User Lists pokemon
        // RouterView -> PokemonListView <-> PokemonRepository <-> PokemonApiService
        // UC002 - User adds favorite pokemon
        // RouterView -> FavoritesView <-> PokemonRepository(add) <-> PostgresService
        // UC003 - User removes favorite pokemon
        // RouterView -> FavoritesView(select and run action) <-> PokemonRepository(remove) <-> PostgresService
        // UC004 - User views pokemon
        // RouterView -> FavoritesView (browse/paginate) <-> PokemonRepository(query) <-> PostgresService
        // UC005 - User wipes all pokemon
        // RouterView -> FavoritesView(wipe) -> PokemonRepository(wipe) -> PostgresService
        try (
            Connection connection = PostgresConnection.createConnection(
                "admin",
                "admin",
                "admin"
            );
            Scanner scanner = new Scanner(System.in)
        ) {
            PokemonRepository pr = new PokemonRepository(
                new PokeApiService(new Gson()),
                connection
            );

            RouterView router = new RouterView(scanner, pr);
            router.loop();
        } catch (SQLException e) {
            System.out.println(
                "Não foi possível conectar ao banco de dados. Verifique se o " +
                    "PostgreSQL está em execução e se as credenciais estão corretas."
            );
            System.out.println("Detalhes: " + e.getMessage());
        }
    }
}
