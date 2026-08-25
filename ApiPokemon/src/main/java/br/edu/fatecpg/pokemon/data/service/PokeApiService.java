package br.edu.fatecpg.pokemon.data.service;

import br.edu.fatecpg.pokemon.data.model.Pokemon;
import br.edu.fatecpg.pokemon.domain.exceptions.PokeApiException;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class PokeApiService {
    // Interacts with https://pokeapi.co/api/v2/pokemon/ and https://pokeapi.co/api/v2/pokemon/10/{id}
    // Method: void listPokemon(int limit, int offset)
    // Method: Pokemon getPokemonDetail(String name)
    private final Gson gson;
    private final HttpClient client;

    public PokeApiService(Gson gson, HttpClient client) {
        this.gson = gson;
        this.client = client;
    }


    public ArrayList<Pokemon> listPokemon(int limit, int offset) throws PokeApiException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://pokeapi.co/api/v2/pokemon?limit=" + limit + "&offset=" + offset))
                .build();
        try {
            HttpResponse<String> response = this.client.send(request, HttpResponse.BodyHandlers.ofString());
            // Turn format '{}' into 'ArrayList<String>'
        } catch (IOException | InterruptedException e) {
            throw new PokeApiException(e.getMessage());
        }

    }

    public DetailedPokemon getPokemonDetail(String name) {
        //
        return new Pokemon(0, "", 0, 0);
    }
}
