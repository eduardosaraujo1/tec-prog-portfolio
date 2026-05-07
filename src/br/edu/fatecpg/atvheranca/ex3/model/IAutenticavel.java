package br.edu.fatecpg.atvheranca.ex3.model;

public interface IAutenticavel {
    boolean login(String usuario, String senha);

    void logout();
}
