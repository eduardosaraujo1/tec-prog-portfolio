package br.edu.fatecpg.atvheranca.ex3.model;

public class SistemaDeSeguranca implements IAutenticavel {
    private static final String USUARIO_CORRETO = "admin";
    private static final String SENHA_CORRETA = "1234";

    private boolean autenticado = false;

    @Override
    public boolean login(String usuario, String senha) {
        // Strings não são estáveis a serem comparadas com ==, pois enquanto Python
        // sobreescreve o comportamento de ==, o Java não.
        if (USUARIO_CORRETO.equals(usuario) && SENHA_CORRETA.equals(senha)) {
            autenticado = true;
            return true;
        }
        autenticado = false;
        return false;
    }

    @Override
    public void logout() {
        autenticado = false;
        System.out.println("Logout realizado com sucesso.");
    }

    public boolean autenticado() {
        return autenticado;
    }
}