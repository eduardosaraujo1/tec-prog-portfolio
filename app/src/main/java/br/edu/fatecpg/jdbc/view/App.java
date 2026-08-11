package br.edu.fatecpg.jdbc.view;

import br.edu.fatecpg.jdbc.banco.Banco;
import br.edu.fatecpg.jdbc.model.Curso;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        try (var conn = Banco.connect()) {
            System.out.println("Conexão ok");

            // String query = "INSERT INTO tb_curso(nome,periodo) VALUES (?,?)";

            // PreparedStatement stmt = conn.prepareStatement(query);
            // stmt.setString(1, "DSM");
            // stmt.setString(2, "Noturno");
            // stmt.execute();

            List<Curso> cursos = new ArrayList<>();
            String query = "SELECT * FROM tb_curso";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                cursos.add(
                    new Curso(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("periodo")
                    )
                );
            }

            cursos.forEach(System.out::println);
            cursos.forEach(c -> System.out.println(c));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
