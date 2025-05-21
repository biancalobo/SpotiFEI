/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import java.sql.*;
import java.util.ArrayList;
import DAO.HistoricoDAO;
import DAO.Conexao;
import DAO.CurtidasDAO;
import Model.Musicas;

/**
 *
 * @author bianc
 */
public class ControllerHistorico {
    
    public void verHistorico(int usuarioId, int musicaId) {
        try {
            Connection conn = Conexao.getConnection();
            HistoricoDAO dao = new CurtidasDAO(conn);
            dao.verHistorico(usuarioId, musicaId);
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar música ao histórico: " + e.getMessage());
        }
    }
    
}
