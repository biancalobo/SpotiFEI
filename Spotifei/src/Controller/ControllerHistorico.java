/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import java.sql.*;
import java.util.ArrayList;
import DAO.Conexao;
import View.PaginaHistorico;
import Model.Historico;
import Model.Musicas;

/**
 *
 * @author bianc
 */
// Classe que controla a lógica do hist´rico
public class ControllerHistorico {
    private PaginaHistorico view;
    private Historico historico;

    // Construtor
    public ControllerHistorico(PaginaHistorico view) {
        this.view = view;
        this.historico = new Historico();
    }

    // Método que mostra as últimas buscas
    public void visualizarUltimasBuscas() {
        ArrayList<Musicas> lista = historico.getBt_musicas_buscadas();

        view.getTxt_area_historico().setText("Últimas Buscas:\n");
        for (Musicas m : lista) {
            view.getTxt_area_historico().append(m.toString() + "\n");
        }
    }

    // Método que mostra as curtidas
    public void visualizarCurtidas() {
        ArrayList<Musicas> lista = historico.getBt_musicas_curtidas();

        view.getTxt_area_historico().setText("Curtidas:\n");
        for (Musicas m : lista) {
            view.getTxt_area_historico().append(m.toString() + "\n");
        }
    }

    // Método que mostra as descurtidas
    public void visualizarDescurtidas() {
        ArrayList<Musicas> lista = historico.getBt_musicas_descurtidas();

        view.getTxt_area_historico().setText("Descurtidas:\n");
        for (Musicas m : lista) {
            view.getTxt_area_historico().append(m.toString() + "\n");
        }
    }
}

