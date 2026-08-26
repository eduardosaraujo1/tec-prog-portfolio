package br.edu.fatecpg.pokemon;

import br.edu.fatecpg.pokemon.data.PokemonRepository;
import br.edu.fatecpg.pokemon.data.service.PokeApiService;
import br.edu.fatecpg.pokemon.data.service.PostgresConnection;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.SQLException;

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
            )
        ) {
            PokemonRepository pr = new PokemonRepository(
                new PokeApiService(new Gson()),
                connection
            );
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
