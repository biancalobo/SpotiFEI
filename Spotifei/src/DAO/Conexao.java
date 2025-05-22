/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 *
 * @author unifbnascimento
 */
public class Conexao {
    public static Connection getConnection() throws SQLException{
        Connection conexao = DriverManager.getConnection(
              "jdbc:postgresql://db.nkmcxgihefnxgdaxykmr.supabase.co:5432/postgres",
                "postgres", "Lobo,svtbz1711");
        return conexao;
}
    }
    
