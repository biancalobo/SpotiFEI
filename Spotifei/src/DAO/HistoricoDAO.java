/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Model.Artista;
import java.sql.*;
import java.util.ArrayList;
import Model.Musicas;
import javax.swing.JOptionPane;

/**
 *
 * @author bianc
 */

// Classe 
public class HistoricoDAO {
    private Connection conn;

    public HistoricoDAO(Connection conn) {
        this.conn = conn;
    }

    public void historicoBuscas(int usuarioId, int musicaId)
                            throws SQLException {
        String sql = "INSERT INTO historico_buscas (id, id_usuario, id_musica)"
                                + " VALUES (?, ?, CURRENT_TIMESTAMP)";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, usuarioId);
            statement.setInt(2, musicaId);
            statement.executeUpdate();
        }
    }

    public ArrayList<Musicas> buscarUltimasBuscas(int usuarioId)
                                                throws SQLException {
        String sql = "SELECT m.id, m.titulo,"
                            + " m.artista FROM historico_buscas h " +
                     "JOIN musica m ON "
                            + "h.musica_id = m.id WHERE h.usuario_id = ? " ;
        
        ArrayList<Musicas> musicas = new ArrayList<>();
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, usuarioId);
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                Musicas musica = new Musicas();
                musica.setId(resultado.getInt("id"));
                musica.setTitulo(resultado.getString("titulo"));
                Artista artista = new Artista();
artista.setNome(resultado.getString("artista"));
                musica.setArtista(artista);
                musicas.add(musica);
            }
        }
        return musicas;
    }

    public ArrayList<Musicas> historicoCurtidas(int usuarioId) 
            throws SQLException {
        String sql = "SELECT m.id, m.titulo, m.artista FROM curtida c " +
                     "JOIN musica m ON c.id_musica = m.id WHERE"
                                    + "c.id_usuario = ? AND c.curtida = TRUE";

        ArrayList<Musicas> musicas = new ArrayList<>();
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, usuarioId);
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                Musicas musica = new Musicas();
                musica.setId(resultado.getInt("id"));
                musica.setTitulo(resultado.getString("titulo"));
                Artista artista = new Artista(resultado.getString("artista"),
                        resultado.getInt("id"));
                musica.setArtista(artista);
                musicas.add(musica);
            }
        }
        return musicas;
    }

    public ArrayList<Musicas> buscarMusicasDescurtidas(int usuarioId)
            throws SQLException {
        String sql = "SELECT m.id, m.titulo, m.artista FROM curtidas c " +
                     "JOIN musica m ON c.id_musica = m.id WHERE"
                                    + " c.id_usuario = ? AND c.curtida = FALSE";

        ArrayList<Musicas> musicas = new ArrayList<>();
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, usuarioId);
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                Musicas musica = new Musicas();
                musica.setId(resultado.getInt("id"));
                musica.setTitulo(resultado.getString("titulo"));
                Artista artista = new Artista(resultado.getString("artista"),
                                                resultado.getInt("id"));
                musica.setArtista(artista);
                musicas.add(musica);
            }
        }
        return musicas;
    }
    
    public void curtirMusica(int usuarioId, int musicaId) throws SQLException {
        String sql = "INSERT INTO curtidas (id, id_usuario, id_musica, curtida)"
                                                + "VALUES (?, ?, TRUE) " +
                     "ON CONFLICT (id_usuario, id_musica) DO UPDATE SET"
                                            + " curtida = TRUE";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, usuarioId);
            stmt.setInt(2, musicaId);
            stmt.executeUpdate();
        }
    }

    public void descurtirMusica(int usuarioId, int musicaId) 
            throws SQLException {
        String sql = "INSERT INTO curtidas (id,id_usuario, id_musica, curtida)"
                                                + " VALUES (?, ?, FALSE) " +
                                "ON CONFLICT (id_usuario, id_musica)"
                                + " DO UPDATE SET curtida = FALSE";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, usuarioId);
            stmt.setInt(2, musicaId);
            stmt.executeUpdate();
        }
    }
    
       
}
