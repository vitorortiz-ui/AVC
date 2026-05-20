package com.mycompany.avc.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao { 

    private static final String URL =
            "jdbc:postgresql://localhost:5432/avc";

    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";

    public static Connection getConnection() {

        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (SQLException e) {
            System.out.println("Erro na conexão:");
            e.printStackTrace();
            return null;
        }
    }
}