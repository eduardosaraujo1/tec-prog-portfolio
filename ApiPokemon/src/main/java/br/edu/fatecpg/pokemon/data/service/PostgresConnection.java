package br.edu.fatecpg.pokemon.data.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnection {

    // Interacts with the JDBC Postgres table

    public static Connection createConnection(
        String user,
        String password,
        String database
    ) throws SQLException {
        String jdbcURL = "jdbc:postgresql://localhost:5432/" + database;

        return DriverManager.getConnection(jdbcURL, user, password);
    }
}
