/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author unifbnascimento
 */

// Classe para as músicas
public class Musicas {
   private String titulo, genero;
   private int id;
   private Artista artista;

   // Construtor não parametrizado
    public Musicas() {
    }

    
    // Construtor totalmente parametrizado
    public Musicas(String titulo, String genero, Artista artista) {
        this.titulo = titulo;
        this.genero = genero;
        this.artista = artista;
    }

    //Getters e setters da classe Musicas
    
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

    // toString da classe Musicas
    @Override
    public String toString() {
        return "ID: " + id + " | Título: " + titulo + " | Gênero: " + genero +
                                        " | Artista: " + artista.getNome();
    }

    
   
}
