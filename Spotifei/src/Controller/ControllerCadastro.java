/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import DAO.UsuarioDAO;
import DAO.Conexao;
import View.PaginaCadastro;
import Model.Usuario;
import javax.swing.JOptionPane;
import java.sql.*;


/**
 *
 * @author unifbnascimento
 */
// Classe que controla a lógica do cadastro
public class ControllerCadastro {
    private PaginaCadastro view;
    
    // Construtor que recebe a view e armazena na variável 'view'
    public ControllerCadastro(PaginaCadastro view){
        this.view = view;
    }
    
    // Método qu realiza o cadastro do funcionário
    public void cadastrarUsuario(){
        String nome = view.getTxt_cadastro_nome().getText();
        String nomeUsuario = view.getTxt_cadastro_usuario().getText();
        String email = view.getTxt_cadastro_email().getText();
        String senha = view.getTxt_cadastro_senha().getText();
        Usuario usuario = new Usuario(nome, nomeUsuario, email, senha);
        Conexao conexao = new Conexao();
        // Try e catch para erros de cadastro
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            dao.cadastrar(usuario);
            JOptionPane.showMessageDialog(view, "Usuário cadastrado!");
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view, "Erro de conexão!");
        }
    }
}
    

