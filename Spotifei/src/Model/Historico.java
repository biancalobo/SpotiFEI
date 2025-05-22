/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.ArrayList;

/**
 *
 * @author bianc
 */
public class Historico {
    private ArrayList<Musicas> ultimasBuscas = new ArrayList<>();
    private ArrayList<Musicas> curtidas = new ArrayList<>();
    private ArrayList<Musicas> descurtidas = new ArrayList<>();

    // ✅ Método para adicionar uma busca
    public void adicionarBusca(Musicas m) {
        ultimasBuscas.add(0, m); // adiciona no início
        if (ultimasBuscas.size() > 10) {
            ultimasBuscas.remove(10); // mantém no máximo 10
        }
    }

    public void curtir(Musicas m) {
        curtidas.add(m);
    }

    public void descurtir(Musicas m) {
        descurtidas.add(m);
    }

    public ArrayList<Musicas> getBt_musicas_buscadas() {
        return ultimasBuscas;
    }

    public ArrayList<Musicas> getBt_musicas_curtidas() {
        return curtidas;
    }

    public ArrayList<Musicas> getBt_musicas_descurtidas() {
        return descurtidas;
    }
}
