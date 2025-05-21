/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import View.PaginaLogin;
import Model.Usuario;
import DAO.UsuarioDAO;
import DAO.Conexao;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author unifbnascimento
 */
public class ControllerLogin {
    private PaginaLogin view;

    public ControllerLogin(PaginaLogin view){
        this.view = view;
    }

    public void loginUsuario(){
        String nomeUsuario = view.getTxt_login_usuario().getText();
        String senha = view.getTxt_login_senha().getText();

        try {
            Connection conn = Conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            Usuario usuario = dao.login(nomeUsuario, senha);

            if (usuario != null) {
                JOptionPane.showMessageDialog(view, 
                                                "Login efetuado com sucesso!",
                        "Aviso", JOptionPane.INFORMATION_MESSAGE);
                view.setVisible(false);

            } else {
                JOptionPane.showMessageDialog(view, "Login inválido!",
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro de conexão: " +
                                                                e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    }
    

