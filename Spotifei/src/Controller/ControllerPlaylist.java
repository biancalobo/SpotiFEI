/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import java.sql.*;
import DAO.PlaylistDAO;
import View.PaginaPlaylist;
import javax.swing.JOptionPane;
import DAO.Conexao;
import Model.Playlist;
import java.util.ArrayList;
/**
 *
 * @author bianc
 */

// Classe Controller da função playlist
public class ControllerPlaylist {
    private PaginaPlaylist view;
    private int idUsuario;

    
    // Construtor da classe ControllerPlaylist
    public ControllerPlaylist(PaginaPlaylist view, int idUsuario) {
        this.view = view;
        this.idUsuario = idUsuario;
    }

    //Esta função cria uma nova playlist
    public void criarPlaylist() {
        String nome = JOptionPane.showInputDialog("Nome da playlist:");
        try {
            Connection conn = Conexao.getConnection();
            PlaylistDAO dao = new PlaylistDAO(conn);
            Playlist playlist = new Playlist(nome,0, idUsuario);
            dao.criar(playlist);
            JOptionPane.showMessageDialog(view, "Playlist criada com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro: " + e.getMessage());
        }
    }

    
    // Esta função lista todas as playlists existentes
    public void listarPlaylists() {
        try {
            Connection conn = Conexao.getConnection();
            PlaylistDAO dao = new PlaylistDAO(conn);
            ArrayList<Playlist> playlists = dao.listarPorUsuario(idUsuario);
            view.getTxt_area_playlist().setText("");
            for (Playlist playlist : playlists) {
                view.getTxt_area_playlist().append("ID: " + playlist.getId() +
                                            " | Nome: " +
                                            playlist.getNome() + "\n");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro: " + e.getMessage());
        }
    }
    
    
    // Esta função serve para excluir uma playlist já existente
    public void excluirPlaylist() {
    String idStr = JOptionPane.showInputDialog(
                                    "Digite o ID da Playlist para excluir:");
    try {
        int id = Integer.parseInt(idStr);
        Connection conn = Conexao.getConnection();
        PlaylistDAO dao = new PlaylistDAO(conn);
        boolean sucesso = dao.excluir(id);
        if (sucesso) {
            JOptionPane.showMessageDialog(view,
                                        "Playlist excluída com sucesso!");
            listarPlaylists();
        } else {
            JOptionPane.showMessageDialog(view, "Playlist não encontrada.");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(view, "Erro: " + e.getMessage());
        }
    }
    
    
    // Esta função adiciona músicas em uma playlist existente
    public void adicionarMusicaNaPlaylist() {
    String idPlaylistStr = JOptionPane.showInputDialog("ID da Playlist:");
    String idMusicaStr = JOptionPane.showInputDialog("ID da Música:");

    try {
        int idPlaylist = Integer.parseInt(idPlaylistStr);
        int idMusica = Integer.parseInt(idMusicaStr);
        Connection conn = Conexao.getConnection();
        PlaylistDAO dao = new PlaylistDAO(conn);
        dao.adicionarMusica(idPlaylist, idMusica);
        JOptionPane.showMessageDialog(view, "Música adicionada com sucesso!");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(view, "Erro: " + e.getMessage());
    }
}
    
    
    // Esta função remove músicas de uma playlist existente
  public void removerMusicaDaPlaylist() {
    String idPlaylistStr = JOptionPane.showInputDialog("ID da Playlist:");
    String idMusicaStr = JOptionPane.showInputDialog("ID da Música:");

    try {
        int idPlaylist = Integer.parseInt(idPlaylistStr);
        int idMusica = Integer.parseInt(idMusicaStr);
        Connection conn = Conexao.getConnection();
        PlaylistDAO dao = new PlaylistDAO(conn);
        dao.removerMusica(idPlaylist, idMusica);
        JOptionPane.showMessageDialog(view, "Música removida com sucesso!");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(view, "Erro: " + e.getMessage());
        }
    }
    
}
