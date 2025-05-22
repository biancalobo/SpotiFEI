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
public class Playlist {
    private String nome;
    private int id, idUsuario;
    private ArrayList<Musicas> musicas = new ArrayList<>();

    public Playlist(String nome, int id, int idUsuario) {
        this.nome = nome;
        this.id = id;
        this.idUsuario = idUsuario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public void adicionarMusica(Musicas musica) {
        musicas.add(musica); 
    }
    public void removerMusica(Musicas musica) {
        musicas.remove(musica); 
    }

    public ArrayList<Musicas> getMusicas() {
        return musicas; 
    }
    public String getNome() {
        return nome; 
    }
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Playlist{" + "nome=" + nome + ", id=" + id + ", idUsuario=" 
                                                            + idUsuario + '}';
    }
    
    
    
}
