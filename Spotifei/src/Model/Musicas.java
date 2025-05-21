/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author unifbnascimento
 */
public class Musicas {
   private String titulo, genero;
   private int id;
   private Artista artista;

    public Musicas() {
    }

    public Musicas(int id, String titulo, String genero, Artista artista) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.artista = artista;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Musicas{" + "titulo=" + titulo + ", genero=" + genero + ", id=" + id + ", artista=" + artista + '}';
    }

    
   
}
