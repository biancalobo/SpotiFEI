/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.*;

/**
 *
 * @author bianc
 */
public class CurtidasDAO {
    private Connection conn;

    public CurtidasDAO(Connection conn) {
        this.conn = conn;
    }

    public void curtir(int usuarioId, int musicaId, boolean curtir) throws SQLException {
        String sql = """
            INSERT INTO curtidas (usuario_id, musica_id, curtida)
            VALUES (?, ?, ?)
            ON CONFLICT (usuario_id, musica_id)
            DO UPDATE SET curtida = EXCLUDED.curtida
        """;

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, usuarioId);
        ps.setInt(2, musicaId);
        ps.setBoolean(3, curtir);
        ps.executeUpdate();
    }
    
}
