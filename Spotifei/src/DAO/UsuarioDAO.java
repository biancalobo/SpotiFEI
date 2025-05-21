/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Model.Usuario;
import java.sql.*;

/**
 *
 * @author unifbnascimento
 */
public class UsuarioDAO {
    private Connection conn;

    public UsuarioDAO(Connection conn) {
        this.conn = conn;
    }
    
    public Usuario login(String nomeUsuario, String senha) throws SQLException {
        String sql = "select * from usuario where nomeusuario = ?"
                                                            + " and senha = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, nomeUsuario);
            statement.setString(2, senha);
            ResultSet resultado = statement.executeQuery();
            if (resultado.next()) {
                return new Usuario(
                    resultado.getString("nome"),
                    resultado.getString("nomeUsuario"),
                    resultado.getString("email"),
                    resultado.getString("senha")
                );
            } else {
                return null;
            }
        }
    }
    
    public void cadastrar(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuarios (nome, nome_user, email, senha_hash) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getNomeUsuario());
            ps.setString(3, usuario.getEmail());
            ps.setString(4, usuario.getSenha());
            ps.executeUpdate();
        }
    
}
}