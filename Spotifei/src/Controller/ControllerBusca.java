/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import DAO.Conexao;
import DAO.MusicasDAO;
import Model.Musicas;
import View.PaginaBusca;
import View.PaginaCadastro;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author unifbnascimento
 */
public class ControllerBusca {
    private PaginaBusca view;
    
    public ControllerBusca(PaginaBusca view){
        this.view = view;
    }
        
    public ArrayList<Musicas> buscar(String tipo, String termo) {
        ArrayList<Musicas> lista = new ArrayList<>();
        try {
            Connection conn = Conexao.getConnection();
            MusicasDAO dao = new MusicasDAO(conn);
            lista = dao.buscar(tipo, termo);
        } catch (SQLException e) {
            // Exibe erro direto na tela, se preferir (opcional)
            System.out.println("Erro no ControllerBusca: " + e.getMessage());
            // ou:
            // JOptionPane.showMessageDialog(view, "Erro ao buscar: " + e.getMessage());
        }

        return lista;
    }
}
