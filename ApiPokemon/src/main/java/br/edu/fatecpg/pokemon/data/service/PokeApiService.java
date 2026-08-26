package br.edu.fatecpg.pokemon.data.service;

import br.edu.fatecpg.pokemon.data.model.Pokemon;
import br.edu.fatecpg.pokemon.data.model.api.PokemonListEntry;
import br.edu.fatecpg.pokemon.data.model.api.PokemonListResponse;
import br.edu.fatecpg.pokemon.domain.exceptions.PokeApiException;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
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

    public List<PokemonListEntry> listPokemon(int limit, int offset)
        throws PokeApiException {
        HttpResponse<String> response = getRequest(
            "https://pokeapi.co/api/v2/pokemon?limit=%d&offset=%d".formatted(
                limit,
                offset
            )
        );

        return parseJson(response.body(), PokemonListResponse.class).results();
    }

    public Pokemon getPokemonDetail(String name) throws PokeApiException {
        HttpResponse<String> response = getRequest(
            "https://pokeapi.co/api/v2/pokemon/" + name
        );
        return parseJson(response.body(), Pokemon.class);
    }

    private HttpResponse<String> getRequest(String url)
        throws PokeApiException {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

            HttpResponse<String> response = this.client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
            );

            if (response.statusCode() < 200 || response.statusCode() > 299) {
                throw new PokeApiException(
                    "Received unsuccessful HTTP status code '%d'".formatted(
                        response.statusCode()
                    )
                );
            }

            return response;
        } catch (IOException | InterruptedException e) {
            throw new PokeApiException(e.getMessage());
        }
    }

    private <T> T parseJson(String json, Class<T> type)
        throws PokeApiException {
        try {
            return gson.fromJson(json, type);
        } catch (
            JsonSyntaxException
            | JsonIOException
            | IllegalStateException e
        ) {
            throw new PokeApiException(
                "Unexpected error when parsing API response: " + e.getMessage()
            );
        }
    }
}
