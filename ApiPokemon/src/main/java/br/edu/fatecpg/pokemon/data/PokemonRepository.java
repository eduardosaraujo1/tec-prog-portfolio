package br.edu.fatecpg.pokemon.data;

import br.edu.fatecpg.pokemon.data.model.Pokemon;
import br.edu.fatecpg.pokemon.data.service.PokeApiService;
import br.edu.fatecpg.pokemon.domain.exceptions.PokeApiException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PokemonRepository {

    private final PokeApiService apiService;
    private final Connection connection;

    public PokemonRepository(PokeApiService apiService, Connection connection) {
        this.apiService = apiService;
        this.connection = connection;
    }

    public List<String> getPokemonList(int limit, int offset)
        throws PokeApiException {
        var entries = apiService.listPokemon(limit, offset);

        return entries
            .stream()
            .map(e -> e.name())
            .toList();
    }

    public void addFavoritePokemon(String name)
        throws PokeApiException, SQLException {
        Pokemon p = apiService.getPokemonDetail(name);

        addFavoritePokemon(p);
    }

    public void addFavoritePokemon(Pokemon p) throws SQLException {
        String sql =
            "INSERT INTO pokemon (id, name, height, weight) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, p.getId());
            stmt.setString(2, p.getName());
            stmt.setInt(3, p.getHeight());
            stmt.setInt(4, p.getWeight());
            stmt.executeUpdate();
            // try-with-resources fecha o objeto stmt
        }
    }

    public void removeFavoritePokemon(String name) throws SQLException {
        String sql = "DELETE FROM pokemon WHERE LOWER(name) = LOWER(?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.executeUpdate();
            // try-with-resources fecha o objeto stmt
        }
    }

    public void removeFavoritePokemon(Pokemon p) throws SQLException {
        if (p != null) {
            removeFavoritePokemon(p.getName());
        }
    }

    public List<Pokemon> getFavoritePokemons() throws SQLException {
        List<Pokemon> pokemon = new ArrayList<>();
        String sql = "SELECT id, name, height, weight FROM pokemon";
        try (
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
        ) {
            while (rs.next()) {
                pokemon.add(
                    new Pokemon(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("height"),
                        rs.getInt("weight")
                    )
                );
            }
        }
        return pokemon;
    }

    public void wipeFavoritePokemons() throws SQLException {
        String sql = "TRUNCATE TABLE pokemon";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.executeUpdate();
        }
    }
}
