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
        
        String sql = "SELECT * FROM musica WHERE " + tipo + " ILIKE ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, "%" + termo + "%");

        ResultSet resultado = statement.executeQuery();
        
        while (resultado.next()) {
            Musicas musica = new Musicas();
            musica.setId(resultado.getInt("id"));
            musica.setTitulo(resultado.getString("titulo"));

            String nomeArtista = resultado.getString("artista");
            Artista artista = new Artista(nomeArtista,0);
            musica.setArtista(artista);

            musica.setGenero(resultado.getString("genero"));
            lista.add(musica);
        }
        
        resultado.close();
        statement.close();
        
        return lista;
    }

    public void curtirMusica(int usuarioId, int musicaId) throws SQLException {
        String sql = "INSERT INTO curtida (id, id_usuario, id_musica,curtida) VALUES (?, ?, TRUE) " +
                     "ON CONFLICT (usuario_id, musica_id) DO UPDATE SET curtir = TRUE";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, usuarioId);
            stmt.setInt(2, musicaId);
            stmt.executeUpdate();
        }
    }

    public void descurtirMusica(int usuarioId, int musicaId) throws SQLException {
        String sql = "INSERT INTO curtidas (usuario_id, musica_id, curtir) VALUES (?, ?, FALSE) " +
                     "ON CONFLICT (usuario_id, musica_id) DO UPDATE SET curtir = FALSE";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, usuarioId);
            stmt.setInt(2, musicaId);
            stmt.executeUpdate();
        }
    }
}