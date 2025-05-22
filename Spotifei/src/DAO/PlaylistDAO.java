/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Model.Playlist;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author bianc
 */

// Classe 
public class PlaylistDAO {
    private Connection conn;

    public PlaylistDAO(Connection conn) {
        this.conn = conn;
    }

    public void criar(Playlist p) throws SQLException {
        String sql = "INSERT INTO playlist (nome, id_usuario) VALUES (?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, p.getNome());
        statement.setInt(2, p.getIdUsuario());
        statement.executeUpdate();
        statement.close();
    }

    public ArrayList<Playlist> listarPorUsuario(int idUsuario) 
                                                    throws SQLException {
        ArrayList<Playlist> lista = new ArrayList<>();
        String sql = "SELECT * FROM playlist WHERE id_usuario = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, idUsuario);
        ResultSet resultado = statement.executeQuery();
        while (resultado.next()) {
            Playlist playlist = new Playlist(resultado.getString("nome"),
                    resultado.getInt("id"), resultado.getInt("id_usuario"));
            lista.add(playlist);
        }
        resultado.close();
        statement.close();
        return lista;
    }
    
    public boolean excluir(int id) throws SQLException {
        String sql = "DELETE FROM playlist WHERE id = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, id);
        int rows = statement.executeUpdate();
        statement.close();
        return rows > 0;
    }
    
    public void adicionarMusica(int idPlaylist, int idMusica)
                                                    throws SQLException {
        String sql = "INSERT INTO playlist_musica (id_playlist, id_musica)"
                                                        + " VALUES (?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, idPlaylist);
        statement.setInt(2, idMusica);
        statement.executeUpdate();
        statement.close();
    }
    
    public void removerMusica(int idPlaylist, int idMusica) 
                                                    throws SQLException {
        String sql = "DELETE FROM playlist_musica WHERE "
                                    + "id_playlist = ? AND id_musica = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, idPlaylist);
        statement.setInt(2, idMusica);
        statement.executeUpdate();
        statement.close();
    }
}
