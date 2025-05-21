/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.*;
import java.util.ArrayList;
import Model.Musicas;

/**
 *
 * @author bianc
 */
public class HistoricoDAO {
    private Connection conn;

    public HistoricoDAO(Connection conn) {
        this.conn = conn;
    }
    
    public void historicoBucas(int usuarioId, int musicaId) throws SQLException {
        String sql = "INSERT INTO historico_busca (usuario_id, musica_id, data_busca) VALUES (?, ?, CURRENT_TIMESTAMP)";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, usuarioId);
            statement.setInt(2, musicaId);
            statement.executeUpdate();
        }
    }
    
    public List<Musica> buscarUltimasBuscas(int usuarioId) throws SQLException {
        String sql = "SELECT m.id, m.titulo, m.artista, m.album FROM historico_busca h " +
                     "JOIN musica m ON h.musica_id = m.id WHERE h.usuario_id = ? " +
                     "ORDER BY h.data_busca DESC LIMIT 10";

        List<Musica> musicas = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, usuarioId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Musica musica = new Musica();
                musica.setId(rs.getInt("id"));
                musica.setTitulo(rs.getString("titulo"));
                musica.setArtista(rs.getString("artista"));
                musica.setAlbum(rs.getString("album"));
                musicas.add(musica);
            }
        }
        return musicas;
    }

    // Busca músicas curtidas pelo usuário
    public ArrayList<Musicas> historicoCurtidas(int usuarioId) throws SQLException {
        String sql = "SELECT m.id, m.titulo, m.artista, m.album FROM curtidas c " +
                     "JOIN musica m ON c.musica_id = m.id WHERE c.usuario_id = ? AND c.curtir = TRUE";

        ArrayList<Musicas> musicas = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, usuarioId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Musicas musica = new Musicas();
                musica.setId(rs.getInt("id"));
                musica.setTitulo(rs.getString("titulo"));
                musica.setArtista(rs.getString("artista"));
                musicas.add(musica);
            }
        }
        return musicas;
    }

    // Busca músicas descurtidas pelo usuário
    public ArrayList<Musicas> buscarMusicasDescurtidas(int usuarioId) throws SQLException {
        String sql = "SELECT m.id, m.titulo, m.artista, m.album FROM curtidas c " +
                     "JOIN musica m ON c.musica_id = m.id WHERE c.usuario_id = ? AND c.curtir = FALSE";

        ArrayList<Musicas> musicas = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, usuarioId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Musicas musica = new Musicas();
                musica.setId(rs.getInt("id"));
                musica.setTitulo(rs.getString("titulo"));
                musica.setArtista(rs.getString("artista"));
                musicas.add(musica);
            }
        }
        return musicas;
    }
}
