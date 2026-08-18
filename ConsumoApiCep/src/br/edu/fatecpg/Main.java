package br.edu.fatecpg;

import br.edu.fatecpg.service.ApiEndereco;

public class Main {
    public static void main(String[] args) {
        var api = new ApiEndereco();
        try {
            System.out.print(api.obterEndereco("11702020"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}