/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author unifbnascimento
 */
public class Artista extends Pessoa {
    private String musica;

    public Artista(String musica) {
        this.musica = musica;
    }

    public String getMusica() {
        return musica;
    }

    public void setMusica(String musica) {
        this.musica = musica;
    }

    @Override
    public String toString() {
        return "Artista{" + "musica=" + musica + '}';
    }
    
    
}
