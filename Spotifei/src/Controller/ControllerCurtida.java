/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import java.sql.*;
import DAO.CurtidasDAO;
import DAO.Conexao;

/**
 *
 * @author bianc
 */
public class ControllerCurtida {
    public void curtir(int usuarioId, int musicaId, boolean curtir) {
        try {
            Connection conn = Conexao.getConnection();
            CurtidasDAO dao = new CurtidasDAO(conn);
            dao.curtir(usuarioId, musicaId, curtir);
        } catch (SQLException e) {
            System.out.println("Erro ao curtir a música: " + e.getMessage());
        }
    }
    
}
