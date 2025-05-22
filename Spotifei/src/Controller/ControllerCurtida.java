/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.Musicas;
import View.PaginaMusicas;
import DAO.HistoricoDAO;
import DAO.Conexao;
import DAO.MusicasDAO;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author bianc
 */
// Classe que controla a lógica das curtidas
public class ControllerCurtida {
    private PaginaMusicas view;
    private int usuarioId;

    // Construtor de ControllerCurtida
    public ControllerCurtida(PaginaMusicas view) {
        this.view = view;
    }

    // Método para curtir músicas
    public void curtirMusica() {
        String idStr = JOptionPane.showInputDialog("ID da música para curtir:");
        if (idStr == null || idStr.isEmpty()) return;
        
        try {
            int id = Integer.parseInt(idStr);
            Connection conn = Conexao.getConnection();
            MusicasDAO dao = new MusicasDAO(conn);

            dao.curtirMusica(usuarioId, id);
            JOptionPane.showMessageDialog(view, "Música curtida com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Erro ao curtir: " +
                                                    e.getMessage());
        }
    }

    public void descurtirMusica() {
        String idStr = 
                JOptionPane.showInputDialog("ID da música para descurtir:");
        if (idStr == null || idStr.isEmpty()) return;

        try {
            int id = Integer.parseInt(idStr);
            Connection conn = Conexao.getConnection();
            MusicasDAO dao = new MusicasDAO(conn);

            dao.descurtirMusica(usuarioId, id);
            JOptionPane.showMessageDialog(view, 
                    "Música descurtida com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Erro ao descurtir: " +
                                                e.getMessage());
        }
    }
    
}
