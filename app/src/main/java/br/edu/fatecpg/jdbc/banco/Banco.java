package br.edu.fatecpg.jdbc.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Banco {

    public static Connection connect() throws SQLException {
        String jdbcURL = "jdbc:postgresql://localhost:5432/admin";
        String user = "admin";
        String passwd = "admin";

        return DriverManager.getConnection(jdbcURL, user, passwd);
    }
}
