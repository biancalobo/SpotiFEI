/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Model.Musicas;
import Model.Artista;
import java.sql.*;
import java.util.*;
/**
 *
 * @author unifbnascimento
 */

// Essa classe é

public class MusicasDAO {
    private Connection conn;

    public MusicasDAO(Connection conn) {
        this.conn = conn;
    }

    public ArrayList<Musicas> buscar(String tipo, String termo) throws SQLException {
        ArrayList<Musicas> lista = new ArrayList<>();

        String coluna;
        if (tipo.equals("titulo")) {
            coluna = "m.titulo";
        } else if (tipo.equals("Artista")) {
            coluna = "a.nome";
        } else {
            coluna = "m.genero";
        }

        String sql = "SELECT m.id, m.titulo, m.genero, a.nome AS artista " +
                     "FROM musicas m JOIN artistas a ON m.artista_id = a.id " +
                     "WHERE LOWER(" + coluna + ") LIKE ?";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, "%" + termo.toLowerCase() + "%");
        ResultSet resultado = statement.executeQuery();

        while (resultado.next()) {
            Artista artista = new Artista(
                resultado.getString("artista")
            );

            Musicas musica = new Musicas(
                resultado.getString("titulo"),
                resultado.getString("genero"),
                artista
            );
            lista.add(musica);
        }

        return lista;
    }
}