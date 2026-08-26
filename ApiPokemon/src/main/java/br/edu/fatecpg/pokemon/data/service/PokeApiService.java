package br.edu.fatecpg.pokemon.data.service;

import br.edu.fatecpg.pokemon.data.model.Pokemon;
import br.edu.fatecpg.pokemon.data.model.api.PokemonListEntry;
import br.edu.fatecpg.pokemon.data.model.api.PokemonListResponse;
import br.edu.fatecpg.pokemon.domain.exceptions.PokeApiException;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class PokeApiService {

    // Interacts with https://pokeapi.co/api/v2/pokemon?limit=X&offset=Y and https://pokeapi.co/api/v2/pokemon/{name}
    // Method: void listPokemon(int limit, int offset)
    // Method: Pokemon getPokemonDetail(String name)
    private final Gson gson;
    private final HttpClient client;

    public PokeApiService(Gson gson) {
        this.gson = gson;
        this.client = HttpClient.newHttpClient();
    }

    private HttpResponse<String> getRequest(String url)
        throws PokeApiException {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
            return this.client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
            );
        } catch (IOException | InterruptedException e) {
            throw new PokeApiException(e.getMessage());
        }
    }

    public List<PokemonListEntry> listPokemon(int limit, int offset)
        throws PokeApiException {
        HttpResponse<String> response = getRequest(
            "https://pokeapi.co/api/v2/pokemon?limit=%d&offset=%d".formatted(
                limit,
                offset
            )
        );
        PokemonListResponse serializado = gson.fromJson(
            response.body(),
            PokemonListResponse.class
        );

        // Usa Streams (coisa que vamos ver no próximo bimestre ou numa próxima aula) para transformar em array de string
        return serializado.results();
    }

    public Pokemon getPokemonDetail(String name) throws PokeApiException {
        HttpResponse<String> response = getRequest(
            "https://pokeapi.co/api/v2/pokemon/" + name
        );
        return gson.fromJson(response.body(), Pokemon.class);
    }
}
