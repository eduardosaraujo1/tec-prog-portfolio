package br.edu.fatecpg.pokemon.ui;

import java.util.Scanner;

public class FavoritesView implements View {

    // UI handling the favorites: paginates each view with detailed pokemon information
    // Has option to "remove" with confirmation dialog
    // Has option to "add" a pokemon by name (internally call the API to store details in the database)
    //
    private final Scanner scanner;

    public FavoritesView(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void loop() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loop'");
    }
}
