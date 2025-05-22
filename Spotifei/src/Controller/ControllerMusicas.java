/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import View.PaginaMusicas;
import Model.Musicas;
import Model.Historico;
import DAO.MusicasDAO;
import DAO.Conexao;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author bianc
 */
public class ControllerMusicas {
    private PaginaMusicas view;
    private Historico historico;

    public ControllerMusicas(PaginaMusicas view) {
        this.view = view;
    }

    public void buscarMusica() {
        String tipo = JOptionPane.showInputDialog("Buscar por: titulo, artista ou genero:");
        String termo = view.getTxt_buscar_musica().getText();

        try {
            Connection conn = Conexao.getConnection();
            MusicasDAO dao = new MusicasDAO(conn);
            ArrayList<Musicas> lista = dao.buscar(tipo, termo);

            view.getTxt_area().setText("Resultados:\n");
            for (Musicas m : lista) {
                view.getTxt_area().append(m.toString() + "\n");

                // ✅ Adicionando no histórico
                historico.adicionarBusca(m);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(view, "Erro: " + e.getMessage());
        }
    }
    
}
