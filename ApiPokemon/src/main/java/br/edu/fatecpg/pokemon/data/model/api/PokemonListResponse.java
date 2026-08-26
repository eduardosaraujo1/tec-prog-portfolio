package br.edu.fatecpg.pokemon.data.model.api;

import java.util.ArrayList;

public record PokemonListResponse(ArrayList<PokemonListEntry> results) {}
