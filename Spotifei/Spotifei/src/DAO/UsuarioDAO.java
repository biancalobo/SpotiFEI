/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author unifbnascimento
 */
public class UsuarioDAO {
    private Connection conn;

    public UsuarioDAO(Connection conn) {
        this.conn = conn;
    }
    
    public ResultSet consultar (Usuario usuario) throws SQLException{
        String sql = "select * from Usuario where usuario = ? and senha = ?";        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, usuario.getNomeUsuario());
        statement.setString(2, usuario.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    
    public void cadastrarUsuario(Usuario usuario) throws SQLException{
        String sql = "insert into aluno(nome, nomeUsuario, email, senha)"
                                                            + " values ('" +
                            usuario.getNome() + "','" +
                            usuario.getNomeUsuario() + "','" +
                            usuario.getEmail() + "','" +
                            usuario.getSenha() + "')";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();
    }
    
}
